package com.finance.common.common.dto.riskfactor;

public record UpdateRiskFactorRequest(
        String factorName,
        String assetClass,
        String regulatoryBucket,
        Integer liquidityHorizon
) { }


