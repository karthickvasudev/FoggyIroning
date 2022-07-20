package com.example.FoggyIroning.securityConfiguration.googleauthenticator;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Builder
@Configuration
@NoArgsConstructor
@AllArgsConstructor
public class TokenDetails {
    private String id;
    private String email;
    private String name;
    private String phoneNumber;
}
