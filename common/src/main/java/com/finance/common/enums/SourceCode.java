package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SourceCode {
    None("None"),
    ISDA("ISDA"),
    Bloomberg("Bloomberg"),
    Reuters("Reuters"),
    ISIN("ISIN"),
    ISO20022("ISO20022"),
    KRX("KRX"),
    CUSIP("CUSIP"),
    SEDOL("SEDOL"),
    MSCI("MSCI"),
    LEI("LEI"),
    ISINIssuerCode("ISINIssuerCode"),
    KRXListedCompanyCode("KRXListedCompanyCode"),
    OTC("OTC"),
    ISO3166("ISO3166"),
    BIC("BIC"),
    RED6("RED6"),
    RED9("RED9"),
    ISO3166PlusBIC4("ISO3166PlusBIC4"),
    Others("Others"),
    FpML("FpML");

    private final String code;

    SourceCode(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static SourceCode fromJson(String input) {
        for (SourceCode t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown ListingSection: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}