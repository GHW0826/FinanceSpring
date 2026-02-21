package com.finance.common.enums.domain.product.Category;

public enum OptPayoffPattern {
    ACB("Accrual Binary", "Accrual Binary"),
    ACC("Accrual", "Accrual"),
    ASN("Asian", "Asian"),
    BAR("Barrier", "Barrier"),
    BIN("Binary", "Binary"),
    FWD("Forward Start", "Forward Start"),
    LAD("Ladder", "Ladder"),
    LBK("Lookback", "Lookback"),
    RAT("Ratchet", "Ratchet"),
    STD("Standard", "Standard"),
    TCH("Touch", "Touch"),
    RBW("Rainbow", "Rainbow"),
    WNT("Warrants", "Warrants");

    private final String eng;
    private final String kor;

    OptPayoffPattern(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getCode() { return name(); }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
    public static OptPayoffPattern fromCode(String code) {
        for (OptPayoffPattern t : values())
            if (t.name().equals(code))
                return t;
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
