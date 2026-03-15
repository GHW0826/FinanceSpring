package com.finance.common.market.dto.interesttradingcontext;

import java.time.LocalDate;

public record CreateInterestTradingContextResponse(
        Long id,
        Long exchangeId,
        Integer settlementDays,
        LocalDate effectiveFrom,
        LocalDate effectiveTo,
        String description,
        String clearingHouse
) { }


