package com.finance.common.common.controller;

import com.finance.common.common.dto.currency.CreateCurrencyRequest;
import com.finance.common.common.dto.currency.CreateCurrencyResponse;
import com.finance.common.common.dto.currency.DeleteCurrencyResponse;
import com.finance.common.common.dto.currency.GetCurrencyResponse;
import com.finance.common.common.service.CurrencyMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currency")
public class CurrencyMasterController {

    private final CurrencyMasterService currencyMasterService;

    @GetMapping("/{ccy}")
    public GetCurrencyResponse getByCcy(@PathVariable String ccy) {
        return currencyMasterService.getCurrencyByCcy(ccy);
    }

    @DeleteMapping("/{ccy}")
    public DeleteCurrencyResponse delete(@PathVariable String ccy) {
        return currencyMasterService.delete(ccy);
    }

    @PostMapping
    public CreateCurrencyResponse create(@RequestBody CreateCurrencyRequest req) {
        return currencyMasterService.create(req);
    }
}