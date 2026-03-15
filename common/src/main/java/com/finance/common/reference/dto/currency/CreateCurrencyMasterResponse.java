package com.finance.common.reference.dto.currency;

public record CreateCurrencyMasterResponse(
        Long id,
        String currencyCode,
        String name,
        String description
) { }