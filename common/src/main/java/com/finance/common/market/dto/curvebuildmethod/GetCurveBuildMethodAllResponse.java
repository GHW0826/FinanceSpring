package com.finance.common.market.dto.curvebuildmethod;

import java.util.List;

public record GetCurveBuildMethodAllResponse(
        List<GetCurveBuildMethodResponse> items
) { }

