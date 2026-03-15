package com.finance.common.reference.dto.Issuer;

public record DeleteIssuerResponse(
        Long id,
        boolean deleted
) { }