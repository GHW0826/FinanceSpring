package com.finance.common.common.dto.nettingset;

public record PutNettingSetResponse(
        Long id,
        Long counterpartyId,
        Long agreementId
) { }

