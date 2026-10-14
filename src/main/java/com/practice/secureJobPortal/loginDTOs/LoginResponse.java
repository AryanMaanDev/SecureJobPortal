package com.practice.secureJobPortal.loginDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class LoginResponse {
    private Integer id;
    private String name;
    private String email;
    private String message;


}
