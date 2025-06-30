package com.finance;

import com.finance.upbit.dto.MarketInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class BinanceExchange implements CryptoExchange {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "https://api.upbit.com/v1/market/all";


    @Override
    public String getExchangeName() {
        return "Binance";
    }
    @Override
    public CryptoAsset fetchTicker(String symbol) {
        String url = "https://api.binance.com/api/v3/ticker/price?symbol=" + symbol;
        BinanceTickerResponse response = restTemplate.getForObject(url, BinanceTickerResponse.class);

        return new CryptoAsset(
                getExchangeName(),
                symbol,
                new BigDecimal(response.price),
                LocalDateTime.now()
        );
    }


    private static class BinanceTickerResponse {
        public String symbol;
        public String price;
    }
}
