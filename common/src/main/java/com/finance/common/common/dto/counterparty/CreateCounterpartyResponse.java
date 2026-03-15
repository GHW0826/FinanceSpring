package com.finance.common.common.dto.counterparty;

public record CreateCounterpartyResponse(
        Long id,
        String counterpartyCode,
        String name,
        String description
) { }


