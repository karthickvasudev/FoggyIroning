package com.example.FoggyIroning.api.v1.customerdatabase.modals;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerModal {
    private String id;
    private String name;

    private String phoneNumber;
    private String address;
    private String city;
    private String pinCode;
    private LocalDateTime createOn;
    private String createUserName;
    private String createUserEmail;
    private LocalDateTime lastUpdatedOn;
    private String lastUpdatedUserName;
    private String lastUpdatedEmail;
}
