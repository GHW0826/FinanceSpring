package com.finance.common.common.dto.payoffpattern;

import java.util.List;

public record GetPayoffPatternAllResponse(
        List<GetPayoffPatternResponse> items
) { }

