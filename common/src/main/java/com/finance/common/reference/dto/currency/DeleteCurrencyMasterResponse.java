package com.finance.common.reference.dto.currency;

public record DeleteCurrencyMasterResponse(
        Long id,
        boolean deleted
) { }