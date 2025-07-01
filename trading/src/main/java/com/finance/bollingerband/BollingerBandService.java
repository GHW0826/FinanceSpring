package com.finance.bollingerband;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BollingerBandService {

    private BollingerBandRepository bollingerBandRepository;

    public BollingerBandService(BollingerBandRepository bollingerBandRepository) {
        this.bollingerBandRepository = bollingerBandRepository;
    }

    public double simpleMovingAverage(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double standardDeviation(List<Double> values, double avg) {
        return Math.sqrt(values.stream().mapToDouble(p -> Math.pow(p - avg, 2)).average().orElse(0));
    }
    public double percentK(List<Double> closes, List<Double> lows, List<Double> highs, int start, int period) {
        List<Double> closeSeg = closes.subList(start, start + period);
        List<Double> lowSeg = lows.subList(start, start + period);
        List<Double> highSeg = highs.subList(start, start + period);
        double low = lowSeg.stream().min(Double::compare).orElse(0.0);
        double high = highSeg.stream().max(Double::compare).orElse(0.0);
        double current = closeSeg.get(period - 1);
        return ((current - low) / (high - low)) * 100.0;
    }


    @Transactional
    public List<BollingerBandResult> calculateSeriesAndSave(String symbol, List<Double> closes, List<Double> lows, List<Double> highs, int period, double k) {
        List<BollingerBandResult> resultList = new ArrayList<>();
        for (int i = 0; i <= closes.size() - period; i++) {
            List<Double> segment = closes.subList(i, i + period);
            double sma = simpleMovingAverage(segment);
            double std = standardDeviation(segment, sma);
            double upper = sma + k * std;
            double lower = sma - k * std;
            double percentKValue = percentK(closes, lows, highs, i, period);

            BollingerBandResult result = new BollingerBandResult(i + period - 1, sma, upper, lower, percentKValue);
            resultList.add(result);

            BollingerBand entity = new BollingerBand();
            entity.setSymbol(symbol);
            entity.setPeriod(period);
            entity.setMiddle(sma);
            entity.setUpper(upper);
            entity.setLower(lower);
            entity.setCalculatedAt(new Date());
            bollingerBandRepository.save(entity);
        }
        return resultList;
    }
}
}