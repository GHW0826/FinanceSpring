package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InterestPayMethod {
    ZeroCouponBond("ZeroCouponBond"),               // 할인채
    CompoundInterestBond("CompoundInterestBond"),   // 복리채
    CouponBond("CouponBond"),                       // 이표채
    SimpleInterestBond("SimpleInterestBond"),       // 단리채
    CompoundThenSimple("CompoundThenSimple"),       // 복5단2
    OtherFixedRate("OtherFixedRate"),               // 고정금리기타
    FloatingRateCouponBond("FloatingRateCouponBond"),// 이표채(변동)
    OtherFloatingRate("OtherFloatingRate");         // 기타(변동)

    private final String code;

    InterestPayMethod(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static InterestPayMethod fromJson(String input) {
        for (InterestPayMethod t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown InterestPayMethod: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}