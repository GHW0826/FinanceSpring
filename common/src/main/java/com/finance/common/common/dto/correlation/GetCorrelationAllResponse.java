package com.finance.common.common.dto.correlation;

import java.util.List;

public record GetCorrelationAllResponse(
        List<GetCorrelationResponse> items
) { }

