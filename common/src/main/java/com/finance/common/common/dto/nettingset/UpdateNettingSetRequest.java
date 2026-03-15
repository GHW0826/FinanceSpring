package com.finance.common.common.dto.nettingset;

public record UpdateNettingSetRequest(
        Long counterpartyId,
        Long agreementId
) { }


