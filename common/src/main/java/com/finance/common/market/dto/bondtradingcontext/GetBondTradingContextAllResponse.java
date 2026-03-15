package com.finance.common.market.dto.bondtradingcontext;

import java.util.List;

public record GetBondTradingContextAllResponse(
        List<GetBondTradingContextResponse> items
) { }

