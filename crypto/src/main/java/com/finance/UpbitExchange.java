package com.finance;

import com.finance.upbit.dto.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UpbitExchange implements CryptoExchange {

    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    public String getExchangeName() {
        return "Upbit";
    }

    @Override
    public CryptoAsset fetchTicker(String symbol) {
        String url = "https://api.upbit.com/v1/ticker?markets=" + symbol;
        UpbitTickerResponse[] response = restTemplate.getForObject(url, UpbitTickerResponse[].class);

        return new CryptoAsset(
                getExchangeName(),
                symbol,
                response[0].trade_price,
                LocalDateTime.now()
        );
    }

    private static class UpbitTickerResponse {
        public String market;
        public BigDecimal trade_price;
    }

    private static final String tickerURL = "https://api.upbit.com/v1/market/all";
    public List<MarketInfo> getMarkets(boolean isDetails) {
        String uri = UriComponentsBuilder.fromHttpUrl(tickerURL)
                .queryParam("isDetails", isDetails)
                .toUriString();

        MarketInfo[] response = restTemplate.getForObject(uri, MarketInfo[].class);
        return Arrays.asList(response);
    }

    private static final String secCandle = "https://api.upbit.com/v1/candles/seconds";
    public List<SecondCandle> getSecondCandles(CandleRequest request) {
        String url = UriComponentsBuilder.fromHttpUrl(tickerURL)
                .queryParam("market", request.getMarket())
                .queryParam("count", request.getCount())
                .queryParam("to", request.getTo()) // nullable
                .toUriString();

        SecondCandle[] response = restTemplate.getForObject(url, SecondCandle[].class);
        return Arrays.asList(response);
    }

    private static final String minuteCandle = "https://api.upbit.com/v1/candles/minutes";
    public List<MinuteCandle> getCandles(MinuteCandleRequest request) {
        String url = UriComponentsBuilder
                .fromHttpUrl(minuteCandle + "/" + request.getUnit())
                .queryParam("market", request.getMarket())
                .queryParam("count", request.getCount())
                .queryParam("to", request.getTo()) // null이면 무시됨
                .toUriString();

        MinuteCandle[] response = restTemplate.getForObject(url, MinuteCandle[].class);
        return Arrays.asList(response);
    }

    private static final String dayCandle = "https://api.upbit.com/v1/candles/days";
    public List<DayCandle> getDayCandles(DayCandleRequest request) {
        String uri = UriComponentsBuilder.fromHttpUrl(dayCandle)
                .queryParam("market", request.getMarket())
                .queryParam("count", request.getCount())
                .queryParam("to", request.getTo())
                .queryParam("converting_price_unit", request.getConvertingPriceUnit())
                .toUriString();

        DayCandle[] response = restTemplate.getForObject(uri, DayCandle[].class);
        return Arrays.asList(response);
    }

    private static final String weekCandle = "https://api.upbit.com/v1/candles/weeks";
    public List<WeekCandle> getWeekCandles(WeekCandleRequest request) {
        String uri = UriComponentsBuilder.fromHttpUrl(weekCandle)
                .queryParam("market", request.getMarket())
                .queryParam("count", request.getCount())
                .queryParam("to", request.getTo()) // null 무시됨
                .toUriString();

        WeekCandle[] response = restTemplate.getForObject(uri, WeekCandle[].class);
        return Arrays.asList(response);
    }

    private static final String monthCandle = "https://api.upbit.com/v1/candles/months";
    public List<MonthCandle> getMonthCandles(MonthCandleRequest request) {
        String uri = UriComponentsBuilder.fromHttpUrl(monthCandle)
                .queryParam("market", request.getMarket())
                .queryParam("count", request.getCount())
                .queryParam("to", request.getTo())
                .toUriString();

        MonthCandle[] response = restTemplate.getForObject(uri, MonthCandle[].class);
        return Arrays.asList(response);
    }

    private static final String yearCandle = "https://api.upbit.com/v1/candles/years";
    public List<YearCandle> getYearCandles(YearCandleRequest request) {
        String uri = UriComponentsBuilder.fromHttpUrl(yearCandle)
                .queryParam("market", request.getMarket())
                .queryParam("count", request.getCount())
                .queryParam("to", request.getTo())
                .toUriString();

        YearCandle[] response = restTemplate.getForObject(uri, YearCandle[].class);
        return Arrays.asList(response);
    }
}