package com.finance.product.controller;

import com.finance.product.service.ProductService;

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
