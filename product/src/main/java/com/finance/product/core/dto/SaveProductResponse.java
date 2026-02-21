package com.finance.product.core.dto;

import com.finance.common.enums.AssetGroup;
import com.finance.common.enums.domain.product.Category.InstGrp;
import com.finance.common.enums.domain.product.Category.PayoffPattern;
import com.finance.common.enums.domain.product.Status;

public record SaveProductResponse(
        Long instrumentId,
        String name,
        Status status,
        AssetGroup assetGrp,
        InstGrp instGrp,
        PayoffPattern payoffPattern
) {}