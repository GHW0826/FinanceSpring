package com.finance.common.common.dto.holiday;

public record UpdateHolidayRequest(
        Long productId,
        String swapSide,
        String appTarget,
        String instCd,
        String cityCd
) { }


