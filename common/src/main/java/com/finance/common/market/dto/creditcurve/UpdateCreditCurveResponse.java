package com.finance.common.market.dto.creditcurve;

import java.util.List;

public record UpdateCreditCurveResponse(
        Long id,
        String name,
        List<Long> pointIds
) { }

