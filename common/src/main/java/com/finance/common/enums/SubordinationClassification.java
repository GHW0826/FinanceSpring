package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SubordinationClassification {
    NONE("NONE"),                           // -
    Senior("Senior"),                       // 선순위
    Mezzanine("Mezzanine"),                 // 중순위
    Subordinated("Subordinated"),           // 후순위
    DeepSubordinated("DeepSubordinated");   // 후후순위

    private final String code;

    SubordinationClassification(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @JsonCreator
    public static SubordinationClassification fromJson(String input) {
        if (input == null || input.isBlank()) return NONE;

        for (SubordinationClassification t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown SubordinationClassification: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}