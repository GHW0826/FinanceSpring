package com.finance.common.common.dto.nettingset;

import java.util.List;

public record GetNettingSetAllResponse(
        List<GetNettingSetResponse> items
) { }

