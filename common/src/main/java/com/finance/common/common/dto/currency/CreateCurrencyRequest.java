package com.finance.common.common.dto.currency;

public record CreateCurrencyRequest(
        String Ccy,
        String Description
) { }