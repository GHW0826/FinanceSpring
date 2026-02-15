package com.finance.product.core.controller;

import com.finance.product.core.service.ProductService;
import com.finance.product.core.dto.SaveProductRequest;
import com.finance.product.core.dto.SaveProductResponse;
import org.springframework.web.bind.annotation.*;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /*
    @GetMapping("/bond")
    public List<GetUnderlyingBondResponse> getAllBonds() {
        return underlyingBondService.getAllBonds();
    }

    // mdCd로 단건 조회
    @GetMapping("/bond/{underlyingCd}")
    public GetUnderlyingBondResponse getBondByMdCd(@PathVariable String underlyingCd) {
        return underlyingBondService.getBondByMdCd(underlyingCd);
    }


    @DeleteMapping("/bond/{underlyingCd}")
    public DeleteUnderlyingBondResponse delete(@PathVariable String underlyingCd) {
        return underlyingBondService.delete(underlyingCd);
    }
     */
}
