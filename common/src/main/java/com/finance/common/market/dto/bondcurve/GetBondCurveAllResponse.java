package com.finance.common.market.dto.bondcurve;

import java.util.List;

public record GetBondCurveAllResponse(
        List<GetBondCurveResponse> items
) { }

