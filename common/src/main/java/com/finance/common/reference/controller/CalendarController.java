package com.finance.common.reference.controller;

import com.finance.common.reference.dto.calendar.calendar.*;
import com.finance.common.reference.service.CalendarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping("/{id}")
    public GetCalendarResponse get(@PathVariable("id") Long id) {
        return calendarService.get(id);
    }

    @PostMapping
    public CreateCalendarResponse create(@Valid @RequestBody CreateCalendarRequest request) {
        return calendarService.create(request);
    }

    @GetMapping
    public GetCalendarAllResponse getAll(
            @RequestParam(name = "active", required = false) Boolean active
    ) {
        return calendarService.getAll(active);
    }

    @PatchMapping("/{id}")
    public UpdateCalendarResponse patch(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateCalendarRequest request
    ) {
        return calendarService.update(id, request);
    }

    @PutMapping("/{id}")
    public PutCalendarResponse put(
            @PathVariable("id") Long id,
            @Valid @RequestBody PutCalendarRequest request
    ) {
        return calendarService.put(id, request);
    }

    @DeleteMapping("/{id}")
    public DeleteCalendarResponse delete(@PathVariable("id") Long id) {
        return calendarService.delete(id);
    }
}