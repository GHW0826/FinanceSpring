package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    LEI,
    BIC,
    REGISTRATION_NO,
    INTERNAL_LEGAL_ENTITY_CODE,
    ISDA_PARTY_ID,
    CUSTOM
 */
public enum IdentifierType {
    LEI("LEI"),
    BIC("BIC"),
    REGISTRATION_NO("RegistrationNo"),
    INTERNAL_LEGAL_ENTITY_CODE("InternalLegalEntityCode"),
    ISDA_PARTY_ID("ISDAPartyId"),
    CUSTOM("Custom");

    private final String code;

    IdentifierType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static IdentifierType fromJson(String input) {
        for (IdentifierType t : values()) {
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