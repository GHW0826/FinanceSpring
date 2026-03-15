package com.finance.common.market.dto.interestvaluationcontext;

import java.time.LocalDate;

public record CreateInterestValuationContextRequest(
        Long vendorId,
        LocalDate effectiveFrom,
        LocalDate effectiveTo,
        String description,
        Long discountCurveId,
        Long projectionCurveId
) { }


