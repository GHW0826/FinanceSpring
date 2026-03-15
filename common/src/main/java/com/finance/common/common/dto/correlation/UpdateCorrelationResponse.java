package com.finance.common.common.dto.correlation;

import java.math.BigDecimal;

public record UpdateCorrelationResponse(
        Long id,
        Long factor1Id,
        Long factor2Id,
        BigDecimal correlationValue
) { }

