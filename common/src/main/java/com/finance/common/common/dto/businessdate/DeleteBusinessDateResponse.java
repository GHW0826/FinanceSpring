package com.finance.common.common.dto.businessdate;

import java.util.Date;

public record DeleteBusinessDateResponse(
        Date businessDate,
        boolean deleted
) { }

