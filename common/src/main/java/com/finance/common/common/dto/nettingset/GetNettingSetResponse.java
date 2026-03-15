package com.finance.common.common.dto.nettingset;

public record GetNettingSetResponse(
        Long id,
        Long counterpartyId,
        Long agreementId
) { }

