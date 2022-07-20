package com.example.FoggyIroning.api.v1.signuplogin.modals;

import com.example.FoggyIroning.securityConfiguration.securityconfig.ApplicationRoles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupModal {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String photoUrl;
    private ApplicationRoles role;
}
