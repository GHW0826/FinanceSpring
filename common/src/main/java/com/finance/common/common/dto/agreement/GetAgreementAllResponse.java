package com.finance.common.common.dto.agreement;

import java.util.List;

public record GetAgreementAllResponse(
        List<GetAgreementResponse> items
) { }

