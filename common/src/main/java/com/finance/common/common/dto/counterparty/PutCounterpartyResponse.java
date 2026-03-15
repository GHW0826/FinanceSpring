package com.finance.common.common.dto.counterparty;

public record PutCounterpartyResponse(
        Long id,
        String counterpartyCode,
        String name,
        String description
) { }

