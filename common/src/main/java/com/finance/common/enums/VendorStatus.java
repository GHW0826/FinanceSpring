package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VendorStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    SUSPENDED("Suspended"),
    DEPRECATED("Deprecated");

    private final String code;

    VendorStatus(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static VendorStatus fromJson(String input) {
        for (VendorStatus t : values()) {
            if (t.code.equalsIgnoreCase(input) || t.name().equalsIgnoreCase(input))
                return t;
        }
        throw new IllegalArgumentException("Unknown code: " + input);
    }

    @JsonValue
    public String toJson() { return code; }
}
