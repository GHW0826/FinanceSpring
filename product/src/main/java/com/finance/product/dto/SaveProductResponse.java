package com.finance.product.dto;

import com.finance.domain.product.AssetGrp;
import com.finance.domain.product.InstGrp;
import com.finance.domain.product.PayoffPattern;
import com.finance.domain.product.Status;

public record SaveProductResponse(
        Long instrumentId,
        String name,
        Status status,
        AssetGrp assetGrp,
        InstGrp instGrp,
        PayoffPattern payoffPattern
) {}