package com.finance;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CryptoAsset {
    private String exchange;       // "Binance", "Upbit"
    private String symbol;         // "BTCUSDT", "KRW-BTC"
    private BigDecimal price;
    private LocalDateTime timestamp;

    public CryptoAsset(String exchange, String symbol, BigDecimal price, LocalDateTime timestamp) {
        this.exchange = exchange;
        this.symbol = symbol;
        this.price = price;
        this.timestamp = timestamp;
    }
}