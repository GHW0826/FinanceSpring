package com.finance;

import com.finance.binance.BinancePriceRequest;
import com.finance.binance.BinanceTickerPrice;
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

    private static final String BASE_URL = "https://api.binance.com/api/v3/ticker/price";
    public List<BinanceTickerPrice> getPrice(BinancePriceRequest request) {
        if (request.getSymbol() == null || request.getSymbol().isBlank()) {
            // 전체 시세
            BinanceTickerPrice[] response = restTemplate.getForObject(BASE_URL, BinanceTickerPrice[].class);
            return Arrays.asList(response);
        }

        // 단일 시세
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("symbol", request.getSymbol())
                .toUriString();
        BinanceTickerPrice response = restTemplate.getForObject(url, BinanceTickerPrice.class);
        return List.of(response);
    }
}
