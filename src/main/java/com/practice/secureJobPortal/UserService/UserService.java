package com.practice.secureJobPortal.UserService;

import com.practice.secureJobPortal.loginDTOs.LoginRequest;
import com.practice.secureJobPortal.loginDTOs.LoginResponse;
import com.practice.secureJobPortal.registrationDTOs.RegisterRequest;

public interface UserService {
    public String registerUser(RegisterRequest registerRequest);

    public LoginResponse loginUser(LoginRequest loginRequest);
}
