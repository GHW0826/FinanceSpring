package com.finance.common.reference.controller;

import com.finance.common.reference.dto.Issuer.*;
import com.finance.common.reference.dto.country.*;
import com.finance.common.reference.service.CountryService;
import com.finance.common.reference.service.IssuerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/issuers")
public class IssuerController {
    private final IssuerService issuerService;

    @GetMapping("/{id}")
    public GetIssuerResponse get(@PathVariable("id") Long id) {
        return issuerService.get(id);
    }

    @PostMapping
    public CreateIssuerResponse create(@Valid @RequestBody CreateIssuerRequest request) {
        return issuerService.create(request);
    }

    @GetMapping
    public GetIssuerAllResponse getAll(
            @RequestParam(name = "active", required = false) Boolean active
    ) {
        return issuerService.getAll(active);
    }

    @PatchMapping("/{id}")
    public UpdateIssuerResponse patch(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateIssuerRequest request
    ) {
        return issuerService.update(id, request);
    }

    @PutMapping("/{id}")
    public PutIssuerResponse put(
            @PathVariable("id") Long id,
            @Valid @RequestBody PutIssuerRequest request
    ) {
        return issuerService.put(id, request);
    }

    @DeleteMapping("/{id}")
    public DeleteIssuerResponse delete(@PathVariable("id") Long id) {
        return issuerService.delete(id);
    }
}