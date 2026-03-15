package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 자산 그룹(Asset Group) Enum (JPA Join 때문에 Master테이블 말고 Enum으로 관리)
 * - CR: 신용 (Credit)
 * - EQ: 주식 (Equity)
 * - FI: 채권 (Fixed Income)
 * - FX: 외환 (Foreign Exchange)
 * - HB: 하이브리드 (Hybrid)
 * - IR: 금리 (Interest Rate)
 */
public enum AssetGroup {
    CREDIT("CREDIT"),
    EQUITY("EQUITY"),
    BOND("BOND"),
    FOREIGNEXCHANGE("FOREIGNEXCHANGE"),
    HYBRID("HYBRID"),
    INTERESTRATE("INTERESTRATE");

    private final String code;

    AssetGroup(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static AssetGroup fromJson(String input) {
        for (AssetGroup t : values()) {
            if (t.code.equalsIgnoreCase(input) || t.name().equalsIgnoreCase(input))
                return t;
        }
        throw new IllegalArgumentException("Unknown code: " + input);
    }

    @JsonValue
    public String toJson() { return code; }
}
