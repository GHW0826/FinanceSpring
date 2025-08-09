package com.finance.product.assetsave;

import com.finance.product.entity.Product;
import com.finance.product.dto.SaveProductRequest;

public interface IProductDetailSave {
    void saveDetail(SaveProductRequest req, Product product);
}
