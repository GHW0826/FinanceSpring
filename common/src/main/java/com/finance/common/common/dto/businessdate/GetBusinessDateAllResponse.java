package com.finance.common.common.dto.businessdate;

import java.util.List;

public record GetBusinessDateAllResponse(
        List<GetBusinessDateResponse> items
) { }

