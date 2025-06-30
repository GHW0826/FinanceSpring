package com.finance.upbit.dto;


import lombok.Data;

@Data
public class MinuteCandleRequest {
    private String market;      // 예: KRW-BTC
    private Integer unit = 1;   // 분 단위 (1,3,5,10,15,...)
    private String to;          // ISO8601 시간 (nullable)
    private Integer count = 10; // 기본값
}