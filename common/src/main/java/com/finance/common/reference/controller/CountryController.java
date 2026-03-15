package com.finance.common.reference.controller;

import com.finance.common.reference.dto.country.*;
import com.finance.common.reference.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/{id}")
    public GetCountryResponse get(@PathVariable("id") Long id) {
        return countryService.get(id);
    }

    @PostMapping
    public CreateCountryResponse create(@Valid @RequestBody CreateCountryRequest request) {
        return countryService.create(request);
    }

    @GetMapping
    public GetCountryAllResponse getAll(@RequestParam(name = "active", required = false) Boolean active) {
        return countryService.getAll(active);
    }

    @PatchMapping("/{id}")
    public UpdateCountryResponse patch(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateCountryRequest request
    ) {
        return countryService.update(id, request);
    }

    @PutMapping("/{id}")
    public PutCountryResponse put(
            @PathVariable("id") Long id,
            @Valid @RequestBody PutCountryRequest request
    ) {
        return countryService.put(id, request);
    }

    @DeleteMapping("/{id}")
    public DeleteCountryResponse delete(@PathVariable("id") Long id) {
        return countryService.delete(id);
    }
}