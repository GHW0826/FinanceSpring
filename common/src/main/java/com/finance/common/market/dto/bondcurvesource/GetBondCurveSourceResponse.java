package com.finance.common.market.dto.bondcurvesource;

import com.finance.common.enums.BondCurveSourceType;

public record GetBondCurveSourceResponse(
        Long id,
        Long bondCurveId,
        Long vendorId,
        BondCurveSourceType sourceType,
        String vendorCurveCode,
        String vendorCurveName,
        Integer priority,
        boolean active,
        String description
) { }

