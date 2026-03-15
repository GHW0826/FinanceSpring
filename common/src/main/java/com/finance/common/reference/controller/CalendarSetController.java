package com.finance.common.reference.controller;

import com.finance.common.reference.dto.calendar.calendarset.*;
import com.finance.common.reference.service.CalendarSetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calendar-sets")
public class CalendarSetController {

    private final CalendarSetService calendarSetService;

    @GetMapping("/{id}")
    public GetCalendarSetResponse get(@PathVariable("id") Long id) {
        return calendarSetService.get(id);
    }

    @PostMapping
    public CreateCalendarSetResponse create(@Valid @RequestBody CreateCalendarSetRequest request) {
        return calendarSetService.create(request);
    }

    @GetMapping
    public GetCalendarSetAllResponse getAll() {
        return calendarSetService.getAll();
    }

    @PatchMapping("/{id}")
    public UpdateCalendarSetResponse patch(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateCalendarSetRequest request
    ) {
        return calendarSetService.update(id, request);
    }

    @PutMapping("/{id}")
    public PutCalendarSetResponse put(
            @PathVariable("id") Long id,
            @Valid @RequestBody PutCalendarSetRequest request
    ) {
        return calendarSetService.put(id, request);
    }

    @DeleteMapping("/{id}")
    public DeleteCalendarSetResponse delete(@PathVariable("id") Long id) {
        return calendarSetService.delete(id);
    }
}