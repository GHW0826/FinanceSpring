package com.finance.common.common.dto;

public record GetInstrumentCategoryResponse(
        String assetGrpCode,
        String instGrpCode,
        String payoffPatternCode,
        String name
) {}
