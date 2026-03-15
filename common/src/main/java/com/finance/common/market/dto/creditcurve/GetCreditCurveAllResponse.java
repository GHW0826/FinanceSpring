package com.finance.common.market.dto.creditcurve;

import java.util.List;

public record GetCreditCurveAllResponse(
        List<GetCreditCurveResponse> items
) { }

