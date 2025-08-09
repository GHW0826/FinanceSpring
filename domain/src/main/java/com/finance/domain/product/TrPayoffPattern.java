package com.finance.domain.product;

public enum TrPayoffPattern {
    FII("Fixed", "Fixed"),
    FIC("Compounding", "Compounding"),
    FLI("Float", "Float"),
    FLC("Compounding Float", "Compounding Float"),
    RFR("RFR Floater", "RFR Floater");

    private final String eng;
    private final String kor;

    TrPayoffPattern(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getCode() { return name(); }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
    public static TrPayoffPattern fromCode(String code) {
        for (TrPayoffPattern t : values())
            if (t.name().equals(code))
                return t;
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
