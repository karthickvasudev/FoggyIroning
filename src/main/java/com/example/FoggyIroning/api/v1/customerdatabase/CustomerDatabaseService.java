package com.example.FoggyIroning.api.v1.customerdatabase;

import com.example.FoggyIroning.api.v1.customerdatabase.modals.CustomerModal;
import com.example.FoggyIroning.securityConfiguration.googleauthenticator.TokenDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerDatabaseService {
    private final TokenDetails tokenDetails;
    private final CustomerDatabaseRepository repository;
    public CustomerDatabase createCustomer(CustomerModal body) {
        Optional<CustomerDatabase> cust = repository.findByPhoneNumber(body.getPhoneNumber());
        if (!cust.isPresent()) {
            CustomerDatabase customer = CustomerDatabase.builder()
                    .name(body.getName())
                    .phoneNumber(body.getPhoneNumber())
                    .address(body.getAddress())
                    .city(body.getCity())
                    .pinCode(body.getPinCode())
                    .createUserName(tokenDetails.getName())
                    .createUserEmail(tokenDetails.getEmail())
                    .createOn(LocalDateTime.now())
                    .build();
            return repository.save(customer);
        }else{
            return cust.get();
        }

    }

    public List<CustomerDatabase> getAllCustomers() {
        return repository.findAll();
    }
}
