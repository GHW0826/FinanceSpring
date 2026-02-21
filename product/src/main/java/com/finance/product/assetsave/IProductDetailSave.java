package com.finance.product.assetsave;

import com.finance.common.product.entity.Product;
import com.finance.product.core.dto.SaveProductRequest;

public interface IProductDetailSave {
    void saveDetail(SaveProductRequest req, Product product);
}
