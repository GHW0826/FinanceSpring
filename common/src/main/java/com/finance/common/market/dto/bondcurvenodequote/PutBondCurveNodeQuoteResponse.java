package com.finance.common.market.dto.bondcurvenodequote;

import com.finance.common.enums.BondPriceType;
import com.finance.common.enums.BondQuoteType;
import com.finance.common.enums.BondQuoteUnit;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PutBondCurveNodeQuoteResponse(
        Long id,
        Long snapshotId,
        Integer nodeSeq,
        Long bondId,
        LocalDate maturityDate,
        String pillarLabel,
        BondQuoteType quoteType,
        BondPriceType priceType,
        BigDecimal bidValue,
        BigDecimal askValue,
        BigDecimal midValue,
        BondQuoteUnit quoteUnit,
        boolean included,
        String excludeReason
) { }

