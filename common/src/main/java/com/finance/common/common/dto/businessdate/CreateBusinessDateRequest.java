package com.finance.common.common.dto.businessdate;

import com.finance.common.enums.domain.product.BusinessSect;
import java.util.Date;

public record CreateBusinessDateRequest(
        Date businessDate,
        Date prevBusinessDate,
        Date nextBusinessDate,
        BusinessSect businessSect,
        Date accCloseDate
) { }


