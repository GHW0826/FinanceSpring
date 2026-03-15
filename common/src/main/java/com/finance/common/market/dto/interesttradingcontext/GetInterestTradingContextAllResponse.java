package com.finance.common.market.dto.interesttradingcontext;

import java.util.List;

public record GetInterestTradingContextAllResponse(
        List<GetInterestTradingContextResponse> items
) { }

