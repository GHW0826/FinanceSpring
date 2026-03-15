package com.finance.common.enums.domain.product.Category;

public enum HbPayoffPattern {
    HFL("Hybrid Floater", "Hybrid Floater"),
    HAC("Hybrid Accrual", "Hybrid Accrual"),
    FIR("Fixed Rate", "Fixed Rate");

    private final String eng;
    private final String kor;

    HbPayoffPattern(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getCode() { return name(); }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
    public static HbPayoffPattern fromCode(String code) {
        for (HbPayoffPattern t : values())
            if (t.name().equals(code))
                return t;
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}