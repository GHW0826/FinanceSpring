package com.finance.product.dto;

import com.finance.domain.product.Category.AssetGrp;
import com.finance.domain.product.Category.InstGrp;
import com.finance.domain.product.Category.PayoffPattern;
import com.finance.domain.product.Status;

public record SaveProductResponse(
        Long instrumentId,
        String name,
        Status status,
        AssetGrp assetGrp,
        InstGrp instGrp,
        PayoffPattern payoffPattern
) {}