package com.finance.common.market.dto.bondvaluationcontext;

import com.finance.common.enums.PriceType;
import java.time.LocalDate;

public record PutBondValuationContextRequest(
        Long vendorId,
        LocalDate effectiveFrom,
        LocalDate effectiveTo,
        String description,
        Long discountCurveId,
        Long spreadCurveId,
        PriceType priceType
) { }


