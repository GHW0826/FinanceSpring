package com.finance.common.common.dto.counterparty;

public record UpdateCounterpartyRequest(
        String counterpartyCode,
        String name,
        String description
) { }


