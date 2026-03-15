package com.finance.common.common.dto.sensitivity;

import java.math.BigDecimal;

public record CreateSensitivityRequest(
        Long productId,
        Long riskFactorId,
        BigDecimal delta,
        BigDecimal vega,
        BigDecimal curvature
) { }


