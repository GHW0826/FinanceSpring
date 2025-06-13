package com.finance.auth.login;

import com.finance.auth.client.Client;
import com.finance.auth.client.ClientRepository;
import com.finance.common.jwt.JwtUtil;
import com.finance.common.response.ResultResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final ClientRepository clientRepository;
    private final JwtUtil jwtUtil;

    public LoginService(ClientRepository clientRepository, JwtUtil jwtUtil) {
        this.clientRepository = clientRepository;
        this.jwtUtil = jwtUtil;
    }

    public ResultResponse<String> login(String userId, String password) {
        Optional<Client> optionalClient = clientRepository.findById(userId);
        if (optionalClient.isEmpty()) {
            return ResultResponse.fail("Client not found");
        }

        Client client = optionalClient.get();
        if (!client.getPassword().equals(password)) {
            return ResultResponse.fail("Invalid password");
        }

        String token = jwtUtil.generateToken(userId);
        return ResultResponse.success(token);
    }
}