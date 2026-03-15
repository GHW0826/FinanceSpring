package com.finance.common.market.dto.creditcurvepoint;

import java.math.BigDecimal;

public record GetCreditCurvePointResponse(
        Long id,
        String name,
        Integer tenorMonth,
        BigDecimal hazardRate,
        BigDecimal survivalProbability,
        Long creditCurveId
) { }

