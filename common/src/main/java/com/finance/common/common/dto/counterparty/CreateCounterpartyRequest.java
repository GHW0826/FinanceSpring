package com.finance.common.common.dto.counterparty;

public record CreateCounterpartyRequest(
        String counterpartyCode,
        String name,
        String description
) { }


