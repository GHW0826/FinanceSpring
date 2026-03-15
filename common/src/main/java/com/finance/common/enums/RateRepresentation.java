package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    ZERO_RATE,        // Zero rate 중심
    DISCOUNT_FACTOR,  // Discount factor 중심
    PAR_YIELD,        // Par yield 중심
    FORWARD_RATE,     // Forward rate 중심
    SPREAD            // Spread(국채대비, swap대비 등)
 */
public enum RateRepresentation {
    ZERO_RATE("ZeroRate"),
    DISCOUNT_FACTOR("DiscountFactor"),
    PAR_YIELD("ParYield"),
    FORWARD_RATE("ForwardRate"),
    SPREAD("Spread");

    private final String code;

    RateRepresentation(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static RateRepresentation fromJson(String input) {
        for (RateRepresentation t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown CurveType: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}