package com.example.FoggyIroning.api.v1.customerdatabase;

import com.example.FoggyIroning.api.v1.customerdatabase.modals.CustomerModal;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
@AllArgsConstructor
public class CustomerDatabaseController {
    private final CustomerDatabaseService service;

    @PostMapping("create")
    public CustomerDatabase createCustomer(@RequestBody CustomerModal body) {
        return service.createCustomer(body);
    }

    @GetMapping("getall")
    public List<CustomerDatabase> getAllCustomer(){
        return service.getAllCustomers();
    }

    @GetMapping("{id}")
    public CustomerDatabase getCustomerDetails(@PathVariable String id){
        return service.getCustomerDetails(id);
    }
}
