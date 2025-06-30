package com.finance.upbit.dto;

import lombok.Data;

@Data
public class DayCandleRequest {
    private String market;                 // 예: KRW-BTC
    private String to;                     // ISO8601 시각 (nullable)
    private Integer count = 10;            // 기본 10개, 최대 200
    private String convertingPriceUnit;    // KRW, USD 등
}