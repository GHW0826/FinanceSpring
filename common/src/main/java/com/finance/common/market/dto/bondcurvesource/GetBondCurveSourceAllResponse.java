package com.finance.common.market.dto.bondcurvesource;

import java.util.List;

public record GetBondCurveSourceAllResponse(
        List<GetBondCurveSourceResponse> items
) { }

