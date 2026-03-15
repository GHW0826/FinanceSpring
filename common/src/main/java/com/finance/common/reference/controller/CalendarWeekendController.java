package com.finance.common.reference.controller;

import com.finance.common.reference.dto.calendar.calendarweekend.*;
import com.finance.common.reference.service.CalendarWeekendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calendar-weekends")
public class CalendarWeekendController {

    private final CalendarWeekendService calendarWeekendService;

    @GetMapping("/{calendarId}/{validFrom}")
    public GetCalendarWeekendResponse get(
            @PathVariable("calendarId") Long calendarId,
            @PathVariable("validFrom")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validFrom
    ) {
        return calendarWeekendService.get(calendarId, validFrom);
    }

    @PostMapping
    public CreateCalendarWeekendResponse create(@Valid @RequestBody CreateCalendarWeekendRequest request) {
        return calendarWeekendService.create(request);
    }

    @GetMapping
    public GetCalendarWeekendAllResponse getAll(@RequestParam(name = "calendarId") Long calendarId) {
        return calendarWeekendService.getAll(calendarId);
    }

    @PatchMapping("/{calendarId}/{validFrom}")
    public UpdateCalendarWeekendResponse patch(
            @PathVariable("calendarId") Long calendarId,
            @PathVariable("validFrom")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validFrom,
            @Valid @RequestBody UpdateCalendarWeekendRequest request
    ) {
        return calendarWeekendService.update(calendarId, validFrom, request);
    }

    @PutMapping("/{calendarId}/{validFrom}")
    public PutCalendarWeekendResponse put(
            @PathVariable("calendarId") Long calendarId,
            @PathVariable("validFrom")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validFrom,
            @Valid @RequestBody PutCalendarWeekendRequest request
    ) {
        return calendarWeekendService.put(calendarId, validFrom, request);
    }

    @DeleteMapping("/{calendarId}/{validFrom}")
    public DeleteCalendarWeekendResponse delete(
            @PathVariable("calendarId") Long calendarId,
            @PathVariable("validFrom")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validFrom
    ) {
        return calendarWeekendService.delete(calendarId, validFrom);
    }
}
