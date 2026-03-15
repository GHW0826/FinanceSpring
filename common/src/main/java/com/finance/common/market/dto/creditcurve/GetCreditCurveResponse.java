package com.finance.common.market.dto.creditcurve;

import java.util.List;

public record GetCreditCurveResponse(
        Long id,
        String name,
        List<Long> pointIds
) { }

