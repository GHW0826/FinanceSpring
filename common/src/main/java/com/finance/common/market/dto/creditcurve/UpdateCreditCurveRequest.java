package com.finance.common.market.dto.creditcurve;

import java.util.List;

public record UpdateCreditCurveRequest(
        String name,
        List<Long> pointIds
) { }


