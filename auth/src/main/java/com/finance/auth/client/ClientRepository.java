package com.finance.auth.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  ClientRepository  extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
    boolean existsByClientId(String clientId);


}
