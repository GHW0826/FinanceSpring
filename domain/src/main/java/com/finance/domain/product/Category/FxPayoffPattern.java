package com.finance.domain.product.Category;

public enum FxPayoffPattern {
    STD("Standard", "Standard"),
    BAR("Barrier", "Barrier"),
    FWD("Forward Start", "Forward Start"),
    LAD("Ladder", "Ladder"),
    RAT("Ratchet", "Ratchet"),
    BIN("Binary", "Binary"),
    TCH("Touch", "Touch");

    private final String eng;
    private final String kor;

    FxPayoffPattern(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getCode() { return name(); }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
    public static FxPayoffPattern fromCode(String code) {
        for (FxPayoffPattern t : values())
            if (t.name().equals(code))
                return t;
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
