package com.finance.common.reference.controller;

import com.finance.common.reference.service.VendorService;
import com.finance.common.reference.dto.vendor.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vendors")
public class VendorController {

    private final VendorService vendorService;

    @GetMapping("/{id}")
    public GetVendorResponse get(@PathVariable("id") Long id) {
        return vendorService.get(id);
    }

    @PostMapping
    public CreateVendorResponse create(@Valid @RequestBody CreateVendorRequest request) {
        return vendorService.create(request);
    }

    @GetMapping
    public GetVendorAllResponse getAll(
            @RequestParam(name = "active", required = false) Boolean active
    ) {
        return vendorService.getAll(active);
    }

    @PatchMapping("/{id}")
    public UpdateVendorResponse patch(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateVendorRequest request
    ) {
        return vendorService.update(id, request);
    }

    @PutMapping("/{id}")
    public PutVendorResponse put(
            @PathVariable("id") Long id,
            @Valid @RequestBody PutVendorRequest request
    ) {
        return vendorService.put(id, request);
    }

    @DeleteMapping("/{id}")
    public DeleteVendorResponse delete(@PathVariable("id") Long id) {
        return vendorService.delete(id);
    }
}