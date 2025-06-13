package com.finance.auth.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Client {
    @Id
    private String clientId;
    private String password;
    private String clientName;
}