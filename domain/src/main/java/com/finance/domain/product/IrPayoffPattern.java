package com.finance.domain.product;

public enum IrPayoffPattern {
    FLR("Floater", "Floater"),
    CUF("Custom Floater", "Custom Floater"),
    ACR("Accrual", "Accrual"),
    ACF("Accrual Floater", "Accrual Floater"),
    CUA("Custom Accrual", "Custom Accrual"),
    VOL("Volatility", "Volatility"),
    VNL("Vanilla Floater", "Vanilla Floater"),
    FIR("Fixed Rate", "Fixed Rate"),
    CFS("Standard", "Standard"),
    CFG("Standard Strategy", "Standard Strategy"),
    CFB("Barrier", "Barrier"),
    CFA("Asian", "Asian"),
    CFD("Digital", "Digital"),
    CFR("Range", "Range"),
    RFR("RFR Floater", "RFR Floater");

    private final String eng;
    private final String kor;

    IrPayoffPattern(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getCode() { return name(); }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
    public static IrPayoffPattern fromCode(String code) {
        for (IrPayoffPattern t : values())
            if (t.name().equals(code))
                return t;
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
