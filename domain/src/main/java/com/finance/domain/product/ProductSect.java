package com.finance.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductSect {
    TEMPLATE("T"),
    PRODUCT("P");

    private final String code;

    ProductSect(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static ProductSect fromJson(String input) {
        for (ProductSect t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown ProductSect: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}