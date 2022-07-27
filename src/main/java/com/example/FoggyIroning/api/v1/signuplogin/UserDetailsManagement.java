package com.example.FoggyIroning.api.v1.signuplogin;

import com.example.FoggyIroning.securityConfiguration.securityconfig.ApplicationRoles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "UserDetailsManagement")
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserDetailsManagement {
    @Id
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String photoUrl;
    @Enumerated(value = EnumType.STRING)
    private ApplicationRoles role;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssa")
    private LocalDateTime createdOn;
}
