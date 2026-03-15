package com.finance.common.reference.controller;

import com.finance.common.reference.dto.currency.*;
import com.finance.common.reference.service.CurrencyMasterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currencies")
public class CurrencyMasterController {

    private final CurrencyMasterService currencyMasterService;

    @GetMapping("/{id}")
    public GetCurrencyMasterResponse get(@PathVariable("id") Long id) {
        return currencyMasterService.get(id);
    }

    @PostMapping
    public CreateCurrencyMasterResponse create(@Valid @RequestBody CreateCurrencyMasterRequest request) {
        return currencyMasterService.create(request);
    }

    @GetMapping
    public GetCurrencyMasterAllResponse getAll(
            @RequestParam(name = "active", required = false) Boolean active
    ) {
        return currencyMasterService.getAll(active);
    }

    @PatchMapping("/{id}")
    public UpdateCurrencyMasterResponse patch(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateCurrencyMasterRequest request
    ) {
        return currencyMasterService.update(id, request);
    }

    @PutMapping("/{id}")
    public PutCurrencyMasterResponse put(
            @PathVariable("id") Long id,
            @Valid @RequestBody PutCurrencyMasterRequest request
    ) {
        return currencyMasterService.put(id, request);
    }

    @DeleteMapping("/{id}")
    public DeleteCurrencyMasterResponse delete(@PathVariable("id") Long id) {
        return currencyMasterService.delete(id);
    }
}