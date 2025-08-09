package com.finance.product;

import com.finance.product.dto.SaveProductRequest;
import com.finance.product.dto.SaveProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // 등록
    @PostMapping("/fi")
    public SaveProductResponse saveFI(@RequestBody SaveProductRequest fi) {
        // return saveProductDispatcher.dispatch(fi);
        return productService.saveFiFwdBfd(fi);
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
