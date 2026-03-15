package com.finance.common.market.dto.interestvaluationcontext;

import java.time.LocalDate;

public record UpdateInterestValuationContextRequest(
        Long vendorId,
        LocalDate effectiveFrom,
        LocalDate effectiveTo,
        String description,
        Long discountCurveId,
        Long projectionCurveId
) { }


