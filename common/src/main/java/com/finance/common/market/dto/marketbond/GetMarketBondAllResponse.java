package com.finance.common.market.dto.marketbond;

import java.util.List;

public record GetMarketBondAllResponse(
        List<GetMarketBondResponse> items
) { }

