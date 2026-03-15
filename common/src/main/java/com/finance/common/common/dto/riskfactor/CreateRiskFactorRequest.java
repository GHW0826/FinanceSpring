package com.finance.common.common.dto.riskfactor;

public record CreateRiskFactorRequest(
        String factorName,
        String assetClass,
        String regulatoryBucket,
        Integer liquidityHorizon
) { }


