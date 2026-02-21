package com.finance.common.market.dto.bond;

import java.util.Date;

public record CreateMarketBondResponse(
        String marketDataCode,
        String name,
        String isinCode,
        Date issueDate,
        Date maturityDate
) {}