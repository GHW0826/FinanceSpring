package com.finance.common.common.dto.sensitivity;

import java.math.BigDecimal;

public record GetSensitivityResponse(
        Long id,
        Long productId,
        Long riskFactorId,
        BigDecimal delta,
        BigDecimal vega,
        BigDecimal curvature
) { }

