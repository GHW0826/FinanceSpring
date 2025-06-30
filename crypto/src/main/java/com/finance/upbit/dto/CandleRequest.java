package com.finance.upbit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandleRequest {

    private String market;           // 필수: 마켓 코드 (예: KRW-BTC)
    private Integer unit = 1;        // 기본값: 1초
    private String to;               // 옵션: 종료 시각 (ISO8601 포맷)
    private Integer count = 10;      // 기본값: 10개 (최대 200)
}