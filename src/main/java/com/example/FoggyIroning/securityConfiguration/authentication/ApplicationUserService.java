package com.example.FoggyIroning.securityConfiguration.authentication;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDAO applicationUserDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDAO
                .selectApplicationUserByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException(username+ "-user not found"));
    }
}
