package com.finance.common.market.dto.marketmaster;

import java.util.List;

public record GetMarketMasterAllResponse(
        List<GetMarketMasterResponse> items
) { }

