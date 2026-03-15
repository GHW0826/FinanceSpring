package com.finance.common.reference.controller;

import com.finance.common.reference.dto.calendar.weekendprofileday.*;
import com.finance.common.reference.service.WeekendProfileDayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weekend-profile-days")
public class WeekendProfileDayController {

    private final WeekendProfileDayService weekendProfileDayService;

    @GetMapping("/{weekendProfileId}/{isoWeekday}")
    public GetWeekendProfileDayResponse get(
            @PathVariable("weekendProfileId") Long weekendProfileId,
            @PathVariable("isoWeekday") Short isoWeekday
    ) {
        return weekendProfileDayService.get(weekendProfileId, isoWeekday);
    }

    @PostMapping
    public CreateWeekendProfileDayResponse create(@Valid @RequestBody CreateWeekendProfileDayRequest request) {
        return weekendProfileDayService.create(request);
    }

    @GetMapping
    public GetWeekendProfileDayAllResponse getAll(@RequestParam(name = "weekendProfileId") Long weekendProfileId) {
        return weekendProfileDayService.getAll(weekendProfileId);
    }

    @PatchMapping("/{weekendProfileId}/{isoWeekday}")
    public UpdateWeekendProfileDayResponse patch(
            @PathVariable("weekendProfileId") Long weekendProfileId,
            @PathVariable("isoWeekday") Short isoWeekday,
            @Valid @RequestBody UpdateWeekendProfileDayRequest request
    ) {
        return weekendProfileDayService.update(weekendProfileId, isoWeekday, request);
    }

    @PutMapping("/{weekendProfileId}/{isoWeekday}")
    public PutWeekendProfileDayResponse put(
            @PathVariable("weekendProfileId") Long weekendProfileId,
            @PathVariable("isoWeekday") Short isoWeekday,
            @Valid @RequestBody PutWeekendProfileDayRequest request
    ) {
        return weekendProfileDayService.put(weekendProfileId, isoWeekday, request);
    }

    @DeleteMapping("/{weekendProfileId}/{isoWeekday}")
    public DeleteWeekendProfileDayResponse delete(
            @PathVariable("weekendProfileId") Long weekendProfileId,
            @PathVariable("isoWeekday") Short isoWeekday
    ) {
        return weekendProfileDayService.delete(weekendProfileId, isoWeekday);
    }
}
