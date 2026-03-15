package com.finance.common.reference.controller;

import com.finance.common.reference.dto.calendar.calendarexception.*;
import com.finance.common.reference.service.CalendarExceptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calendar-exceptions")
public class CalendarExceptionController {

    private final CalendarExceptionService calendarExceptionService;

    @GetMapping("/{calendarId}/{exceptionDate}")
    public GetCalendarExceptionResponse get(
            @PathVariable("calendarId") Long calendarId,
            @PathVariable("exceptionDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exceptionDate
    ) {
        return calendarExceptionService.get(calendarId, exceptionDate);
    }

    @PostMapping
    public CreateCalendarExceptionResponse create(
            @Valid @RequestBody CreateCalendarExceptionRequest request
    ) {
        return calendarExceptionService.create(request);
    }

    @GetMapping
    public GetCalendarExceptionAllResponse getAll(
            @RequestParam(name = "calendarId") Long calendarId
    ) {
        return calendarExceptionService.getAll(calendarId);
    }

    @PatchMapping("/{calendarId}/{exceptionDate}")
    public UpdateCalendarExceptionResponse patch(
            @PathVariable("calendarId") Long calendarId,
            @PathVariable("exceptionDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exceptionDate,
            @Valid @RequestBody UpdateCalendarExceptionRequest request
    ) {
        return calendarExceptionService.update(calendarId, exceptionDate, request);
    }

    @PutMapping("/{calendarId}/{exceptionDate}")
    public PutCalendarExceptionResponse put(
            @PathVariable("calendarId") Long calendarId,
            @PathVariable("exceptionDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exceptionDate,
            @Valid @RequestBody PutCalendarExceptionRequest request
    ) {
        return calendarExceptionService.put(calendarId, exceptionDate, request);
    }

    @DeleteMapping("/{calendarId}/{exceptionDate}")
    public DeleteCalendarExceptionResponse delete(
            @PathVariable("calendarId") Long calendarId,
            @PathVariable("exceptionDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exceptionDate
    ) {
        return calendarExceptionService.delete(calendarId, exceptionDate);
    }
}