package com.finance.domain.product;

public enum CancelType {
    CALLABLE("CA", "CA"),
    PUTTABLE("PU", "PU"),
    CALLANDPUT("CP", "CP");

    private final String eng;
    private final String kor;

    CancelType(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getCode() { return name(); }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
    public static CancelType fromCode(String code) {
        for (CancelType t : values())
            if (t.name().equals(code))
                return t;
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
