package com.finance.common.market.dto.creditcurvepoint;

import java.util.List;

public record GetCreditCurvePointAllResponse(
        List<GetCreditCurvePointResponse> items
) { }

