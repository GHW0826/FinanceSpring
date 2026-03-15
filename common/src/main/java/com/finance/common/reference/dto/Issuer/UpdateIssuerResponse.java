package com.finance.common.reference.dto.Issuer;

public record UpdateIssuerResponse(
        Long issuerId,
        String issuerCode,
        String name,
        Long countryId,
        String lei,
        Long parentIssuerId,
        boolean groupFlag,
        boolean active,
        String description
) { }