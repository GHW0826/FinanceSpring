package com.finance.common.common.dto.counterparty;

public record UpdateCounterpartyResponse(
        Long id,
        String counterpartyCode,
        String name,
        String description
) { }

