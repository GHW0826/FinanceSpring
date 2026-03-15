package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AssetSecuritizationClassification {
    NONE("NONE"),
    AssetBackedSecurityBondType("AssetBackedSecurityBondType"),                                         // ABS(채권형)
    AssetBackedSecurityBeneficialCertificateType("AssetBackedSecurityBeneficialCertificateType"),       // ABS(수익증권형)
    AssetBackedSecurityNonStandardType("AssetBackedSecurityNonStandardType"),                           // ABS(비정형)
    MortgageBackedSecurityBondType("MortgageBackedSecurityBondType"),                                   // MBS(채권형)
    MortgageBackedSecurityBeneficialCertificateType("MortgageBackedSecurityBeneficialCertificateType"); // MBS(수익증권형)


    private final String code;

    AssetSecuritizationClassification(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static AssetSecuritizationClassification fromJson(String input) {
        for (AssetSecuritizationClassification t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown AssetSecuritizationClassification: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}