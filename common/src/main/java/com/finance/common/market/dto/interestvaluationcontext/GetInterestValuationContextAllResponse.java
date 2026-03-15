package com.finance.common.market.dto.interestvaluationcontext;

import java.util.List;

public record GetInterestValuationContextAllResponse(
        List<GetInterestValuationContextResponse> items
) { }

