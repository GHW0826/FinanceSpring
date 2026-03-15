package com.finance.common.reference.dto.currency;

public record UpdateCurrencyMasterResponse(
        Long id,
        String currencyCode,
        String name,
        String description
) { }