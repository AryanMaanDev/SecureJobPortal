package com.practice.secureJobPortal.registrationDTOs;

import lombok.Data;

@Data
public class RegisterResponse {
    private Integer id ;
    private String name;
    private String email;
    private String message;
}
