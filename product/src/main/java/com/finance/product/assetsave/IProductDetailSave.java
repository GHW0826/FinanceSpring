package com.finance.product.assetsave;

import com.finance.entity.product.Product;
import com.finance.product.core.dto.SaveProductRequest;

public interface IProductDetailSave {
    void saveDetail(SaveProductRequest req, Product product);
}
