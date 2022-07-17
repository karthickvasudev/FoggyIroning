package com.example.FoggyIroning.api.v1.signuplogin;

import com.example.FoggyIroning.api.v1.signuplogin.modals.SignupModal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsManagementService {
    private UserDetailsManagementRepository repository;

    public UserDetailsManagement signupLogin(SignupModal signupModal) {
        Optional<UserDetailsManagement> user = repository.findByEmail(signupModal.getEmail());
        if (user.isEmpty()) {
            UserDetailsManagement newUser = UserDetailsManagement.builder()
                    .userId(signupModal.getId())
                    .email(signupModal.getEmail())
                    .name(signupModal.getName())
                    .photoUrl(signupModal.getPhotoUrl())
                    .role(signupModal.getRole())
                    .createdOn(LocalDateTime.now())
                    .build();
            return repository.save(newUser);
        }
        return user.get();
    }
}
