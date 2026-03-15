package com.finance.common.common.dto.riskfactor;

public record PutRiskFactorResponse(
        Long id,
        String factorName,
        String assetClass,
        String regulatoryBucket,
        Integer liquidityHorizon
) { }

