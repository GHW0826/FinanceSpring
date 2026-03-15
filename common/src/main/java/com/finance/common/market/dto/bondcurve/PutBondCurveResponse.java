package com.finance.common.market.dto.bondcurve;

import com.finance.common.enums.CurvePurpose;
import com.finance.common.enums.CurveType;
import com.finance.common.enums.RateRepresentation;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PutBondCurveResponse(
        Long id,
        String curveCode,
        String name,
        Long currencyId,
        CurveType curveType,
        CurvePurpose curvePurpose,
        RateRepresentation rateRepresentation,
        boolean active,
        LocalDate validFrom,
        LocalDate validTo,
        String description,
        Long issuerId,
        boolean onTheRunOnly,
        BigDecimal minRemainingYears,
        BigDecimal minOutstandingAmount,
        boolean outputIncludesYtm,
        boolean outputIncludesZero,
        boolean outputIncludesDf
) { }

