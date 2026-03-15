package com.finance.common.common.dto.etc;

public record GetInstrumentCategoryResponse(
        String assetGrpCode,
        String instGrpCode,
        String payoffPatternCode,
        String name
) {}
