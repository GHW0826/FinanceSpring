package com.finance.common.market.dto.creditcurve;

import java.util.List;

public record CreateCreditCurveRequest(
        String name,
        List<Long> pointIds
) { }


