package com.finance.common.common.dto.correlation;

import java.math.BigDecimal;

public record CreateCorrelationRequest(
        Long factor1Id,
        Long factor2Id,
        BigDecimal correlationValue
) { }


