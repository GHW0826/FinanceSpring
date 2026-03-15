package com.finance.common.common.dto.nettingset;

public record PutNettingSetRequest(
        Long counterpartyId,
        Long agreementId
) { }


