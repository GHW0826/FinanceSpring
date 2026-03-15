package com.finance.common.reference.dto.Issuer;

public record UpdateIssuerRequest(
        String issuerCode,
        String name,
        Long countryId,
        String lei,
        Long parentIssuerId,
        Boolean groupFlag,
        Boolean active,
        String description
) { }
