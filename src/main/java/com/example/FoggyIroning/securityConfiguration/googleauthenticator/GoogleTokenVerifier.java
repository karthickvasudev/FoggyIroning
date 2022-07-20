package com.example.FoggyIroning.securityConfiguration.googleauthenticator;

import com.example.FoggyIroning.api.v1.signuplogin.UserDetailsManagement;
import com.example.FoggyIroning.api.v1.signuplogin.UserDetailsManagementRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public class GoogleTokenVerifier extends OncePerRequestFilter {
    private final TokenDetails tokenDetails;
    private final UserDetailsManagementRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if (Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            String clientId = "164846260896-0e34nt61sli435li3t69nrr98b23feh4.apps.googleusercontent.com";
            String token = authorizationHeader.replace("Bearer ", "");
            System.out.println("---  "+token);
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                    .setAudience(Collections.singleton(clientId))
                    .build();
            GoogleIdToken idToken = verifier.verify(token);
            if (idToken != null) {
                Optional<UserDetailsManagement> user = repository.findById(idToken.getPayload().getUserId());
                if (user.isPresent()) {
                    tokenDetails.setId(user.get().getUserId());
                    tokenDetails.setEmail(user.get().getEmail());
                    tokenDetails.setPhoneNumber(user.get().getPhoneNumber());
                    tokenDetails.setName(user.get().getName());
                } else {
                    throw new IllegalStateException("--user not found--");
                }
                Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        user.get().getUserId(),
                        null,
                        grantedAuthorities
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new IllegalStateException("token error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("token error");
        }
        filterChain.doFilter(request, response);
    }
}
