package com.finance.binance;

import lombok.Data;

@Data
public class BinanceTickerPrice {
    private String symbol;
    private String price;
}