package com.finance.product.assetsave;

// fixed income

import com.finance.product.entity.Product;
import com.finance.product.dto.SaveProductRequest;

public class ProductFiSave implements IProductDetailSave {
    @Override
    public void saveDetail(SaveProductRequest req, Product product) {
        /*
        ProductFiDto fiDto = convertToFiDto(req.getDetail());
        ProductFi fi = new ProductFi();
        fi.setCoupon(fiDto.getCoupon());
        fi.setProduct(product);
        product.setFiDetail(fi);
         */
    }
}