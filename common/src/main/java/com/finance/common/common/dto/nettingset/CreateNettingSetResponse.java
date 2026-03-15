package com.finance.common.common.dto.nettingset;

public record CreateNettingSetResponse(
        Long id,
        Long counterpartyId,
        Long agreementId
) { }


