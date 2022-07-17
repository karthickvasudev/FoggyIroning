package com.example.FoggyIroning.api.v1.signuplogin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsManagementRepository extends JpaRepository<UserDetailsManagement, String> {
    Optional<UserDetailsManagement> findByEmail(String email);
}
