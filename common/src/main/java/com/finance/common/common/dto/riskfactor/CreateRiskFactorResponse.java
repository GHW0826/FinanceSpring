package com.finance.common.common.dto.riskfactor;

public record CreateRiskFactorResponse(
        Long id,
        String factorName,
        String assetClass,
        String regulatoryBucket,
        Integer liquidityHorizon
) { }


