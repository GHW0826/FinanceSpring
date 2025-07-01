package com.finance.bollingerband;

public class BollingerBandResult {
    public double middle;
    public double upper;
    public double lower;
    public double sma;
    public double percentK;

    public BollingerBandResult(double middle, double upper, double lower, double sma, double percentK) {
        this.middle = middle;
        this.upper = upper;
        this.lower = lower;
        this.sma = sma;
        this.percentK = percentK;
    }

    @Override
    public String toString() {
        return "Middle: " + middle + ", Upper: " + upper + ", Lower: " + lower + ", %K: " + percentK;
    }
}
