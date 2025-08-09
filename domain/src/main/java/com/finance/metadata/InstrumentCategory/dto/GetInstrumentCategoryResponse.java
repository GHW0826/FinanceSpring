package com.finance.metadata.InstrumentCategory.dto;

public record GetInstrumentCategoryResponse(
        String assetGrpCode,
        String instGrpCode,
        String payoffPatternCode,
        String name
) {}
