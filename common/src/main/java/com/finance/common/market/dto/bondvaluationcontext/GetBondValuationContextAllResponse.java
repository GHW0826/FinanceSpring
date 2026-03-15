package com.finance.common.market.dto.bondvaluationcontext;

import java.util.List;

public record GetBondValuationContextAllResponse(
        List<GetBondValuationContextResponse> items
) { }

