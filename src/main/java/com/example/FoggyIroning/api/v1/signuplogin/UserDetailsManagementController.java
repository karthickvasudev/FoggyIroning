package com.example.FoggyIroning.api.v1.signuplogin;

import com.example.FoggyIroning.api.v1.signuplogin.modals.SignupModal;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/userdetailsmanagement")
@AllArgsConstructor
public class UserDetailsManagementController {
    private UserDetailsManagementService service;
    @PostMapping("loginsignup")
    public UserDetailsManagement loginSignup(@RequestBody SignupModal signupModal){
        System.out.println(signupModal);
        return service.signupLogin(signupModal);
    }
}
