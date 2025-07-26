package com.finance;

import com.finance.binance.BinancePriceRequest;
import com.finance.binance.BinanceTickerPrice;
import com.finance.upbit.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trading/crypto")
public class CryptoController {
    private final UpbitExchange upbitExchange;
    private final BinanceExchange binanceExchange;

    public CryptoController(UpbitExchange upbitExchange, BinanceExchange binanceExchange) {
        this.upbitExchange = upbitExchange;
        this.binanceExchange = binanceExchange;
    }

    @GetMapping("/upbit/ticker")
    public List<MarketInfo> getTicker() {
        return upbitExchange.getMarkets(false);
    }


    /**
     * 초봉 조회 API
     * @param market ex) KRW-BTC
     * @param unit 초 단위 (ex: 1, 10, 30, 60)
     * @param to (선택) 종료 시간 (ISO8601)
     * @param count 최대 200
     */
    @GetMapping("/seconds")
    public List<SecondCandle> getSecondCandles(@RequestBody CandleRequest request)  {
        return upbitExchange.getSecondCandles(request);
    }


    /**
     * 업비트 분봉(분 단위 캔들) 조회 API
     *
     * <p>
     * 분 단위 (1, 3, 5, 10, 15, 30, 60, 240분)로 구성된 캔들 데이터를 조회합니다.
     * 캔들은 실제 체결이 있었던 시간에만 생성되며, 조회 기준 시간 'to'는 exclusive (제외 기준)입니다.
     * 업비트 API는 UTC 또는 KST 시간 포맷 모두를 지원합니다.
     * </p>
     *
     * @param market 마켓 코드 (예: KRW-BTC)
     * @param unit 캔들 단위 (분 단위: 1, 3, 5, 10, 15, 30, 60, 240 중 하나)
     * @param to (선택) 마지막 캔들 기준 시각 (exclusive). ISO8601 포맷. 비우면 최신 기준
     * @param count 요청할 캔들 개수. 1~200개 제한 (기본값 10)
     * @return 분봉 데이터 리스트
     */
    @GetMapping("/minutes")
    public List<MinuteCandle> getMinuteCandles(@RequestBody MinuteCandleRequest request) {
        return upbitExchange.getCandles(request);
    }

    /**
     * 업비트 일봉 캔들 조회 API
     *
     * <p>
     * 종목의 일 단위 캔들(시가/고가/저가/종가/거래량 등)을 조회합니다.
     * 'to'는 종료 기준 시각 (exclusive)이며, 기본은 최신 기준입니다.
     * 'convertingPriceUnit'을 지정하면 USD 등의 통화로 거래금액 변환이 가능합니다.
     * </p>
     *
     * @param request DayCandleRequest JSON 바디 (market, count, to, convertingPriceUnit)
     * @return 일봉 리스트 (최대 200개)
     */
    @GetMapping("/days")
    public List<DayCandle> getDayCandles(@RequestBody DayCandleRequest request) {
        return upbitExchange.getDayCandles(request);
    }

    /**
     * 업비트 주봉 캔들 조회 API
     *
     * <p>
     * 주 단위로 생성된 캔들을 조회합니다.
     * 각 캔들은 해당 주의 첫째 날 기준으로 구성되며,
     * 'to'는 종료 기준 시각 (exclusive)으로, 지정하지 않으면 최신 기준입니다.
     * </p>
     *
     * @param request WeekCandleRequest JSON 요청 바디
     * @return 주봉 캔들 리스트
     */
    @GetMapping("/weeks")
    public List<WeekCandle> getWeekCandles(@RequestBody WeekCandleRequest request) {
        return upbitExchange.getWeekCandles(request);
    }

    /**
     * 업비트 월봉 캔들 조회 API
     *
     * <p>
     * 종목의 월 단위 시세 데이터를 조회합니다.
     * 'to'는 마지막 캔들의 기준 시각 (exclusive)이며, 지정하지 않으면 최신 기준으로 반환됩니다.
     * </p>
     *
     * @param request MonthCandleRequest JSON 바디 (market, to, count)
     * @return 월봉 캔들 리스트
     */
    @GetMapping("/months")
    public List<MonthCandle> getMonthCandles(@RequestBody MonthCandleRequest request) {
        return upbitExchange.getMonthCandles(request);
    }


    /**
     * 업비트 년봉 캔들 조회 API
     *
     * <p>
     * 종목의 연 단위 시세 데이터를 조회합니다.
     * 'to'는 종료 기준 시각 (exclusive)이며, 지정하지 않으면 최신 기준으로 반환됩니다.
     * </p>
     *
     * @param request YearCandleRequest JSON 바디
     * @return 년봉 캔들 리스트
     */
    @GetMapping("/years")
    public List<YearCandle> getYearCandles(@RequestBody YearCandleRequest request) {
        return upbitExchange.getYearCandles(request);
    }



    /**
     * Binance 시세 조회 API
     * - symbol 지정 시 해당 거래쌍 시세 1건
     * - symbol 미지정 시 전체 시세 리스트 반환
     *
     * @param request symbol 포함 요청 (비어도 가능)
     * @return 시세 리스트 (항상 List 형태)
     */
    @GetMapping("/binance/price")
    public List<BinanceTickerPrice> getPrice(@RequestBody BinancePriceRequest request) {
        return binanceExchange.getPrice(request);
    }
}