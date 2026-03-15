package com.finance.common.common.dto.correlation;

import java.math.BigDecimal;

public record CreateCorrelationResponse(
        Long id,
        Long factor1Id,
        Long factor2Id,
        BigDecimal correlationValue
) { }


