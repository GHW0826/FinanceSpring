package com.finance.common.common.dto.holiday;

public record PutHolidayRequest(
        Long productId,
        String swapSide,
        String appTarget,
        String instCd,
        String cityCd
) { }


