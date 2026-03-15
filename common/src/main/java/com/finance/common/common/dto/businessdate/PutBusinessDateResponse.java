package com.finance.common.common.dto.businessdate;

import com.finance.common.enums.domain.product.BusinessSect;
import java.util.Date;

public record PutBusinessDateResponse(
        Date businessDate,
        Date prevBusinessDate,
        Date nextBusinessDate,
        BusinessSect businessSect,
        Date accCloseDate
) { }

