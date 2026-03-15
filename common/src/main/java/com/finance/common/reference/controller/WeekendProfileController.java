package com.finance.common.reference.controller;

import com.finance.common.reference.dto.calendar.weekendprofile.*;
import com.finance.common.reference.service.WeekendProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weekend-profiles")
public class WeekendProfileController {

    private final WeekendProfileService weekendProfileService;

    @GetMapping("/{id}")
    public GetWeekendProfileResponse get(@PathVariable("id") Long id) {
        return weekendProfileService.get(id);
    }

    @PostMapping
    public CreateWeekendProfileResponse create(@Valid @RequestBody CreateWeekendProfileRequest request) {
        return weekendProfileService.create(request);
    }

    @GetMapping
    public GetWeekendProfileAllResponse getAll() {
        return weekendProfileService.getAll();
    }

    @PatchMapping("/{id}")
    public UpdateWeekendProfileResponse patch(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateWeekendProfileRequest request
    ) {
        return weekendProfileService.update(id, request);
    }

    @PutMapping("/{id}")
    public PutWeekendProfileResponse put(
            @PathVariable("id") Long id,
            @Valid @RequestBody PutWeekendProfileRequest request
    ) {
        return weekendProfileService.put(id, request);
    }

    @DeleteMapping("/{id}")
    public DeleteWeekendProfileResponse delete(@PathVariable("id") Long id) {
        return weekendProfileService.delete(id);
    }
}
