package com.finance.common.common.dto.riskfactor;

public record PutRiskFactorRequest(
        String factorName,
        String assetClass,
        String regulatoryBucket,
        Integer liquidityHorizon
) { }


