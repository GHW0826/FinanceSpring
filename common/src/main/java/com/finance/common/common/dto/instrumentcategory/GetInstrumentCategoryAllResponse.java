package com.finance.common.common.dto.instrumentcategory;

import java.util.List;

public record GetInstrumentCategoryAllResponse(
        List<GetInstrumentCategoryResponse> items
) { }

