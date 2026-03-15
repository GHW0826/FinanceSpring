package com.finance.common.reference.dto.country;

public record DeleteCountryResponse(
        Long id,
        boolean deleted
) { }