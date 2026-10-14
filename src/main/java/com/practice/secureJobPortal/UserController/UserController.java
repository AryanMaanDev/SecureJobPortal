package com.practice.secureJobPortal.UserController;

import com.practice.secureJobPortal.UserService.UserService;
import com.practice.secureJobPortal.loginDTOs.LoginRequest;
import com.practice.secureJobPortal.loginDTOs.LoginResponse;
import com.practice.secureJobPortal.registrationDTOs.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest userRequest){
        return userService.registerUser(userRequest);
    }

    @GetMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }
}
