package com.finance.common.common.dto.instrumentcategory;

public record DeleteInstrumentCategoryResponse(
        String instrumentGroupCode,
        boolean deleted
) { }

