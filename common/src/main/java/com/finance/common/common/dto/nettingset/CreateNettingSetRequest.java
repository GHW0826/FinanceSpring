package com.finance.common.common.dto.nettingset;

public record CreateNettingSetRequest(
        Long counterpartyId,
        Long agreementId
) { }


