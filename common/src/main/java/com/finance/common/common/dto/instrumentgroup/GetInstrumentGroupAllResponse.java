package com.finance.common.common.dto.instrumentgroup;

import java.util.List;

public record GetInstrumentGroupAllResponse(
        List<GetInstrumentGroupResponse> items
) { }

