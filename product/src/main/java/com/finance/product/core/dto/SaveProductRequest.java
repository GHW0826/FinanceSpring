package com.finance.product.core.dto;

import com.finance.domain.product.Category.AssetGrp;
import com.finance.domain.product.Category.InstGrp;
import com.finance.domain.product.Category.PayoffPattern;
import com.finance.domain.product.Position;
import com.finance.domain.product.ProductSect;
import com.finance.domain.product.Status;
import com.finance.enums.ModelSect;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class SaveProductRequest {
    protected String name;
    protected Status status;
    protected AssetGrp assetGrp;
    protected InstGrp instGrp;
    protected PayoffPattern payoffPattern;
    protected ProductSect productSect;
    protected Position position;
    protected ModelSect modelSect;
}
