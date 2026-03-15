package com.finance.common.common.dto.counterparty;

public record PutCounterpartyRequest(
        String counterpartyCode,
        String name,
        String description
) { }


