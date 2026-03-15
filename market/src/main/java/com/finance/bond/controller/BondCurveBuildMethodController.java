package com.finance.bond.controller;

import com.finance.bond.service.BondCurveBuildMethodService;
import com.finance.common.market.dto.bondcurvebuildmethod.CreateBondCurveBuildMethodRequest;
import com.finance.common.market.dto.bondcurvebuildmethod.CreateBondCurveBuildMethodResponse;
import com.finance.common.market.dto.bondcurvebuildmethod.GetBondCurveBuildMethodResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bond-curves")
public class BondCurveBuildMethodController {
    private final BondCurveBuildMethodService bondCurveBuildMethodService;

    @PostMapping
    public CreateBondCurveBuildMethodResponse create(@RequestBody CreateBondCurveBuildMethodRequest req) {
        return bondCurveBuildMethodService.create(req);
    }

    @GetMapping("/{id}")
    public GetBondCurveBuildMethodResponse get(@PathVariable Long id) {
        return bondCurveBuildMethodService.get(id);
    }
}
