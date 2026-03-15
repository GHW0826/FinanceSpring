package com.finance.common.reference.dto.Issuer;


public record CreateIssuerRequest(
        String issuerCode,
        String name,
        Long countryId,
        String lei,
        Long parentIssuerId,
        boolean groupFlag,
        boolean active,
        String description
) { }

