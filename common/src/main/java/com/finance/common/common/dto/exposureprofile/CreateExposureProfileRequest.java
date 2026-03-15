package com.finance.common.common.dto.exposureprofile;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateExposureProfileRequest(
        Long productId,
        Long nettingSetId,
        LocalDate timePoint,
        BigDecimal expectedExposure,
        BigDecimal potentialFutureExposure
) { }


