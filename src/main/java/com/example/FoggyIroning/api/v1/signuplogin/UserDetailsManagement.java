package com.example.FoggyIroning.api.v1.signuplogin;

import com.example.FoggyIroning.securityConfiguration.securityconfig.ApplicationRoles;
import lombok.*;

import javax.persistence.Entity;
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
    private String photoUrl;
    private ApplicationRoles role;
    private LocalDateTime createdOn;
}
