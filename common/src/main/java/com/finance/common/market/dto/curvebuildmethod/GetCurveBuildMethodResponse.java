package com.finance.common.market.dto.curvebuildmethod;

import com.finance.common.enums.BootstrapAlgorithm;
import com.finance.common.enums.BusinessDayConvention;
import com.finance.common.enums.CompoundingFrequency;
import com.finance.common.enums.CompoundingType;
import com.finance.common.enums.DayCountConvention;
import com.finance.common.enums.ExtrapolationMethod;
import com.finance.common.enums.InterpolationMethod;

public record GetCurveBuildMethodResponse(
        Long id,
        String name,
        InterpolationMethod interpolationMethod,
        ExtrapolationMethod extrapolationMethod,
        BootstrapAlgorithm bootstrapAlgorithm,
        DayCountConvention dayCount,
        CompoundingType compoundingType,
        CompoundingFrequency compoundingFrequency,
        BusinessDayConvention businessDayConvention,
        Long calendarId,
        Integer settlementDays,
        String description
) { }

