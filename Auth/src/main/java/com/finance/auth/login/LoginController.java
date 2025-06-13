package com.finance.auth.login;

import com.finance.auth.login.dto.LoginRequest;
import com.finance.common.response.ResultResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResultResponse<String> login(@RequestBody LoginRequest request) {
        return loginService.login(request.getClientId(), request.getPassword());
    }
}
