package com.finance.common.market.dto.bondcurvepoint;

import java.util.List;

public record GetBondCurvePointAllResponse(
        List<GetBondCurvePointResponse> items
) { }

