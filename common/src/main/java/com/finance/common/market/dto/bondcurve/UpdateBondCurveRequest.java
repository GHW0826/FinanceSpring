package com.finance.common.market.dto.bondcurve;

import com.finance.common.enums.CurvePurpose;
import com.finance.common.enums.CurveType;
import com.finance.common.enums.RateRepresentation;
import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateBondCurveRequest(
        String curveCode,
        String name,
        Long currencyId,
        CurveType curveType,
        CurvePurpose curvePurpose,
        RateRepresentation rateRepresentation,
        Boolean active,
        LocalDate validFrom,
        LocalDate validTo,
        String description,
        Long issuerId,
        Boolean onTheRunOnly,
        BigDecimal minRemainingYears,
        BigDecimal minOutstandingAmount,
        Boolean outputIncludesYtm,
        Boolean outputIncludesZero,
        Boolean outputIncludesDf
) { }


