package com.finance.product.fi.controller;

import com.finance.product.core.dto.SaveProductResponse;
import com.finance.product.fi.dto.SaveFixedIncomeRequest;
import com.finance.product.fi.service.FixedIncomeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/fi")
public class FixedIncomeController {
    private final FixedIncomeService fixedIncomeService;

    public FixedIncomeController(FixedIncomeService fixedIncomeService) {
        this.fixedIncomeService = fixedIncomeService;
    }

    // 등록
    @PostMapping
    public SaveProductResponse Create(@RequestBody SaveFixedIncomeRequest fi) {
        return fixedIncomeService.Create(fi);
    }

    /*
    @GetMapping("{id}}")
    public List<GetUnderlyingBondResponse> getFiProduct() {
        return fiproductService.getAllBonds();
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
