package com.finance.common.product.entity.dto;

import com.finance.common.enums.AssetGroup;
import com.finance.common.enums.domain.product.Category.InstGrp;
import com.finance.common.enums.domain.product.Category.PayoffPattern;
import com.finance.common.enums.domain.product.Position;
import com.finance.common.enums.domain.product.ProductSect;
import com.finance.common.enums.domain.product.Status;
import com.finance.common.enums.ModelSect;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class SaveProductRequest {
    protected String name;
    protected Status status;
    protected AssetGroup assetGrp;
    protected InstGrp instGrp;
    protected PayoffPattern payoffPattern;
    protected ProductSect productSect;
    protected Position position;
    protected ModelSect modelSect;
}
