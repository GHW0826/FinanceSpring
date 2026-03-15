package com.finance.common.common.dto.holiday;

import java.util.List;

public record GetHolidayAllResponse(
        List<GetHolidayResponse> items
) { }

