package com.finance.domain.product.Category;

public enum CapFloorPayoffPattern {
    CFS("Standard", "Standard"),
    CFG("Standard Strategy", "Standard Strategy"),
    CFB("Barrier", "Barrier"),
    CFA("Asian", "Asian"),
    CFD("Digital", "Digital"),
    CFR("Range", "Range");

    private final String eng;
    private final String kor;

    CapFloorPayoffPattern(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getCode() { return name(); }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
    public static CapFloorPayoffPattern fromCode(String code) {
        for (CapFloorPayoffPattern t : values())
            if (t.name().equals(code))
                return t;
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}