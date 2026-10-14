package com.practice.secureJobPortal.loginDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class LoginRequest {
    private String email;
    private String password;
}
