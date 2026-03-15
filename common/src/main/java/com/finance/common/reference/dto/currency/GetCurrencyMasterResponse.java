package com.finance.common.reference.dto.currency;

public record GetCurrencyMasterResponse(
        Long id,
        String currencyCode,
        String name,
        String description
) { }