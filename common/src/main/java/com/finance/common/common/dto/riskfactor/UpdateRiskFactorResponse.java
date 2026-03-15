package com.finance.common.common.dto.riskfactor;

public record UpdateRiskFactorResponse(
        Long id,
        String factorName,
        String assetClass,
        String regulatoryBucket,
        Integer liquidityHorizon
) { }

