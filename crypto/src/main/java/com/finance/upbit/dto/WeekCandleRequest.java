package com.finance.upbit.dto;

import lombok.Data;

@Data
public class WeekCandleRequest {
    private String market;           // 예: KRW-BTC
    private String to;               // ISO8601 시각 (nullable)
    private Integer count = 10;      // 기본값 10, 최대 200
}