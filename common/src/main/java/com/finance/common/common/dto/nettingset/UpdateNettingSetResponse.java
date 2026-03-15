package com.finance.common.common.dto.nettingset;

public record UpdateNettingSetResponse(
        Long id,
        Long counterpartyId,
        Long agreementId
) { }

