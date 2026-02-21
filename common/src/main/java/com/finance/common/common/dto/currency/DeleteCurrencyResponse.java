package com.finance.common.common.dto.currency;

public record DeleteCurrencyResponse(
        String Ccy,
        boolean deleted
) { }