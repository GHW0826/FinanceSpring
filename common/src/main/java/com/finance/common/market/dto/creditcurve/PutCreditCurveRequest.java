package com.finance.common.market.dto.creditcurve;

import java.util.List;

public record PutCreditCurveRequest(
        String name,
        List<Long> pointIds
) { }


