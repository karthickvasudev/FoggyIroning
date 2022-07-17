package com.example.FoggyIroning.securityConfiguration.securityconfig;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationRoles {
    SUPERADMIN,
    OWNER,
    EMPLOYEE,
    USER;

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> set = new HashSet<>();
        set.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return set;
    }
}
