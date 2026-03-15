package com.finance.common.market.dto.bondcurvenodequote;

import java.util.List;

public record GetBondCurveNodeQuoteAllResponse(
        List<GetBondCurveNodeQuoteResponse> items
) { }

