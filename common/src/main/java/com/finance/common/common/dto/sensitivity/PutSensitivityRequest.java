package com.finance.common.common.dto.sensitivity;

import java.math.BigDecimal;

public record PutSensitivityRequest(
        Long productId,
        Long riskFactorId,
        BigDecimal delta,
        BigDecimal vega,
        BigDecimal curvature
) { }


