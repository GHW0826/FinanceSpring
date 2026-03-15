package com.finance.common.market.dto.bond;

import com.finance.common.enums.CouponFrequency;
import com.finance.common.enums.CouponType;
import com.finance.common.enums.DayCountConvention;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GetMarketBondResponse(
        Long id,
        String marketCode,
        Long vendorId,
        String name,
        Long currencyId,
        Long defaultTradingContextId,
        Long defaultValuationContextId,
        String description,
        String isin,
        Long issuerId,
        LocalDate issueDate,
        LocalDate maturityDate,
        CouponType couponType,
        BigDecimal couponRate,
        CouponFrequency couponFrequency,
        DayCountConvention dayCountConvention,
        BigDecimal faceValue,
        BigDecimal redemption
) { }
