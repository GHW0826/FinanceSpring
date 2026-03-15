package com.finance.common.market.dto.yieldcurve;

import java.util.List;

public record GetYieldCurveAllResponse(
        List<GetYieldCurveResponse> items
) { }

