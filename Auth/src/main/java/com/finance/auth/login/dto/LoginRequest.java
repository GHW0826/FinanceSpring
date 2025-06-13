package com.finance.auth.login.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String clientId;
    private String password;
}
