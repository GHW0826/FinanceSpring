package com.finance.common.common.dto.counterparty;

public record GetCounterpartyResponse(
        Long id,
        String counterpartyCode,
        String name,
        String description
) { }

