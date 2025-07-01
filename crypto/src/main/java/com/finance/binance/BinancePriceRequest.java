package com.finance.binance;

import lombok.Data;

@Data
public class BinancePriceRequest {
    private String symbol; // e.g. BTCUSDT (대문자)
}