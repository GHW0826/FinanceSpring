package com.finance.upbit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    private String market;

    @JsonProperty("korean_name")
    private String koreanName;

    @JsonProperty("english_name")
    private String englishName;

    @JsonProperty("market_event")
    private MarketEvent marketEvent;

    // Getter & Setter 생략
}