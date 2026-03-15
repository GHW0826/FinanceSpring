package com.finance.common.enums.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BookStatus {
    STANDBY("StandBy"),
    POSITION("Position"),
    BOOKED("Booked"),
    CLOSED("Closed"),
    DELETED("Deleted"),
    CANCEL("Cancel");

    private final String code;

    BookStatus(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BookStatus fromJson(String input) {
        for (BookStatus t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown Status: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}