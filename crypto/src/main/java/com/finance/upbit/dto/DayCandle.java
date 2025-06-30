package com.finance.upbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DayCandle {

    private String market;

    @JsonProperty("candle_date_time_utc")
    private LocalDateTime candleDateTimeUtc;

    @JsonProperty("candle_date_time_kst")
    private LocalDateTime candleDateTimeKst;

    @JsonProperty("opening_price")
    private double openingPrice;

    @JsonProperty("high_price")
    private double highPrice;

    @JsonProperty("low_price")
    private double lowPrice;

    @JsonProperty("trade_price")
    private double tradePrice;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("candle_acc_trade_price")
    private double accTradePrice;

    @JsonProperty("candle_acc_trade_volume")
    private double accTradeVolume;

    @JsonProperty("prev_closing_price")
    private double prevClosingPrice;

    private String change;

    @JsonProperty("change_price")
    private double changePrice;

    @JsonProperty("change_rate")
    private double changeRate;

    @JsonProperty("converted_trade_price")
    private Double convertedTradePrice; // optional
}