package com.finance.common.enums.domain.product.Category;

public enum EqPayoffPattern {
    STD("Standard", "Standard"),
    BAR("Barrier", "Barrier"),
    FWD("Forward Start", "Forward Start"),
    LAD("Ladder", "Ladder"),
    RAT("Ratchet", "Ratchet"),
    BIN("Binary", "Binary"),
    TCH("Touch", "Touch");

    private final String eng;
    private final String kor;

    EqPayoffPattern(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getCode() { return name(); }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
    public static EqPayoffPattern fromCode(String code) {
        for (EqPayoffPattern t : values())
            if (t.name().equals(code))
                return t;
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}