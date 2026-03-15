package com.finance.common.common.dto.holiday;

public record CreateHolidayResponse(
        Long id,
        Long productId,
        String swapSide,
        String appTarget,
        String instCd,
        String cityCd
) { }


