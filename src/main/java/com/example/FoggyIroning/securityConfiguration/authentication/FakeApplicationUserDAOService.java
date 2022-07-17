package com.example.FoggyIroning.securityConfiguration.authentication;

import com.example.FoggyIroning.securityConfiguration.securityconfig.ApplicationRoles;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository("fake")
public class FakeApplicationUserDAOService implements ApplicationUserDAO {
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String userName) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> userName.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Arrays.asList(new ApplicationUser(
                ApplicationRoles.SUPERADMIN.getGrantedAuthority(),
                "pradeep",
                passwordEncoder.encode("pradeep12")
        ));
        return applicationUsers;
    }
}
