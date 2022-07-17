package com.example.FoggyIroning.securityConfiguration.authentication;

import java.util.Optional;

public interface ApplicationUserDAO {
    public Optional<ApplicationUser> selectApplicationUserByUserName(String userName);

}
