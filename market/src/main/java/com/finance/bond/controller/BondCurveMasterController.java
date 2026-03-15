package com.finance.bond.controller;

import com.finance.bond.service.BondCurveMasterService;
import com.finance.common.market.dto.bond.CreateBondCurveMasterRequest;
import com.finance.common.market.dto.bond.CreateBondCurveMasterResponse;
import com.finance.common.market.dto.bond.GetBondCurveMasterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bond-curve")
public class BondCurveMasterController {
    private final BondCurveMasterService bondCurveMasterService;

    @PostMapping
    public CreateBondCurveMasterResponse create(@RequestBody CreateBondCurveMasterRequest req) {
        return bondCurveMasterService.create(req);
    }

    @GetMapping("/{id}")
    public GetBondCurveMasterResponse get(@PathVariable Long id) {
        return bondCurveMasterService.get(id);
    }
}