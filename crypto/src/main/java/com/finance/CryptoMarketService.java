package com.finance;

import org.springframework.stereotype.Service;

@Service
public class CryptoMarketService {

    private final ExchangeRegistry exchangeRegistry;

    public CryptoMarketService(ExchangeRegistry exchangeRegistry) {
        this.exchangeRegistry = exchangeRegistry;
    }

    public CryptoAsset getTicker(String exchange, String symbol) {
        CryptoExchange provider = exchangeRegistry.getExchange(exchange);
        if (provider == null) {
            throw new IllegalArgumentException("Unsupported exchange: " + exchange);
        }
        return provider.fetchTicker(symbol);
    }
}