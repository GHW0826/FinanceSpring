package com.finance.domain.product.Category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 자산 그룹(Asset Group) Enum
 * - CR: 신용 (Credit)
 * - EQ: 주식 (Equity)
 * - FI: 채권 (Fixed Income)
 * - FX: 외환 (Foreign Exchange)
 * - HB: 하이브리드 (Hybrid)
 * - IR: 금리 (Interest Rate)
 */
public enum AssetGrp {
    CREDIT("CR"),
    EQUITY("EQ"),
    FIXEDINCOME("FI"),
    FOREIGNEXCHANGE("FX"),
    HYBRID("HB"),
    INTERESTRATE("IR");

    private final String code;

    AssetGrp(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static AssetGrp fromJson(String input) {
        for (AssetGrp t : values()) {
            if (t.code.equalsIgnoreCase(input) || t.name().equalsIgnoreCase(input))
                return t;
        }
        throw new IllegalArgumentException("Unknown code: " + input);
    }

    @JsonValue
    public String toJson() { return code; }
}
