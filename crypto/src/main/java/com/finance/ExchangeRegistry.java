package com.finance;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ExchangeRegistry {

    private final Map<String, CryptoExchange> exchangeMap;

    public ExchangeRegistry(List<CryptoExchange> exchanges) {
        this.exchangeMap = exchanges.stream()
                .collect(Collectors.toMap(CryptoExchange::getExchangeName, e -> e));
    }

    public CryptoExchange getExchange(String name) {
        return exchangeMap.get(name);
    }

    public List<String> listExchanges() {
        return new ArrayList<>(exchangeMap.keySet());
    }
}