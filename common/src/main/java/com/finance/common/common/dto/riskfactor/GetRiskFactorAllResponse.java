package com.finance.common.common.dto.riskfactor;

import java.util.List;

public record GetRiskFactorAllResponse(
        List<GetRiskFactorResponse> items
) { }

