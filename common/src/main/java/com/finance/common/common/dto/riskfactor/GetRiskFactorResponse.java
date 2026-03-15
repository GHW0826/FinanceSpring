package com.finance.common.common.dto.riskfactor;

public record GetRiskFactorResponse(
        Long id,
        String factorName,
        String assetClass,
        String regulatoryBucket,
        Integer liquidityHorizon
) { }

