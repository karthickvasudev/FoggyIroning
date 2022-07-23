package com.example.FoggyIroning.api.v1.customerdatabase;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDatabaseRepository extends JpaRepository<CustomerDatabase,String> {
    Optional<CustomerDatabase> findByPhoneNumber(String phoneNumber);
}
