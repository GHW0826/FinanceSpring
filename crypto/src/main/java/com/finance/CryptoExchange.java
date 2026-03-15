package com.finance;

public interface CryptoExchange {
    String getExchangeName();                // 예: "Binance"
    CryptoAsset fetchTicker(String symbol);
}