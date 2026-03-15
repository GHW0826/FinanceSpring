package com.finance.common.market.dto.bondcurvesource;

import com.finance.common.enums.BondCurveSourceType;

public record UpdateBondCurveSourceRequest(
        Long bondCurveId,
        Long vendorId,
        BondCurveSourceType sourceType,
        String vendorCurveCode,
        String vendorCurveName,
        Integer priority,
        Boolean active,
        String description
) { }


