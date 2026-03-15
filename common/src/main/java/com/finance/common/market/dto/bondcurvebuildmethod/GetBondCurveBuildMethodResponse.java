package com.finance.common.market.dto.bondcurvebuildmethod;

import com.finance.common.enums.BusinessDayConvention;
import com.finance.common.enums.CompoundingFrequency;
import com.finance.common.enums.CompoundingType;
import com.finance.common.enums.CurveFittingMethod;
import com.finance.common.enums.DayCountConvention;
import com.finance.common.enums.ExtrapolationMethod;
import com.finance.common.enums.InterpolationMethod;

public record GetBondCurveBuildMethodResponse(
        Long id,
        String buildMethodCode,
        String name,
        CurveFittingMethod fittingMethod,
        InterpolationMethod interpolationMethod,
        ExtrapolationMethod extrapolationMethod,
        DayCountConvention dayCountConvention,
        CompoundingType compoundingType,
        CompoundingFrequency compoundingFrequency,
        BusinessDayConvention businessDayConvention,
        Long calendarId,
        Integer settlementDays,
        boolean active,
        String description
) { }

