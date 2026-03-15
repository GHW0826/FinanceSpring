package com.finance.common.market.dto.bondtradingcontext;

import com.finance.common.enums.ListingSection;
import java.math.BigDecimal;
import java.time.LocalDate;

public record GetBondTradingContextResponse(
        Long id,
        Long exchangeId,
        Integer settlementDays,
        LocalDate effectiveFrom,
        LocalDate effectiveTo,
        String description,
        ListingSection listingSection,
        BigDecimal tickSize,
        BigDecimal lotSize
) { }

