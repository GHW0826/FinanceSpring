package com.finance.common.reference.controller;

import com.finance.common.reference.dto.calendar.calendarsetmember.*;
import com.finance.common.reference.service.CalendarSetMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calendar-set-members")
public class CalendarSetMemberController {

    private final CalendarSetMemberService calendarSetMemberService;

    @GetMapping("/{calendarSetId}/{calendarId}")
    public GetCalendarSetMemberResponse get(
            @PathVariable("calendarSetId") Long calendarSetId,
            @PathVariable("calendarId") Long calendarId
    ) {
        return calendarSetMemberService.get(calendarSetId, calendarId);
    }

    @PostMapping
    public CreateCalendarSetMemberResponse create(@Valid @RequestBody CreateCalendarSetMemberRequest request) {
        return calendarSetMemberService.create(request);
    }

    @GetMapping
    public GetCalendarSetMemberAllResponse getAll(@RequestParam(name = "calendarSetId") Long calendarSetId) {
        return calendarSetMemberService.getAll(calendarSetId);
    }

    @PatchMapping("/{calendarSetId}/{calendarId}")
    public UpdateCalendarSetMemberResponse patch(
            @PathVariable("calendarSetId") Long calendarSetId,
            @PathVariable("calendarId") Long calendarId,
            @Valid @RequestBody UpdateCalendarSetMemberRequest request
    ) {
        return calendarSetMemberService.update(calendarSetId, calendarId, request);
    }

    @PutMapping("/{calendarSetId}/{calendarId}")
    public PutCalendarSetMemberResponse put(
            @PathVariable("calendarSetId") Long calendarSetId,
            @PathVariable("calendarId") Long calendarId,
            @Valid @RequestBody PutCalendarSetMemberRequest request
    ) {
        return calendarSetMemberService.put(calendarSetId, calendarId, request);
    }

    @DeleteMapping("/{calendarSetId}/{calendarId}")
    public DeleteCalendarSetMemberResponse delete(
            @PathVariable("calendarSetId") Long calendarSetId,
            @PathVariable("calendarId") Long calendarId
    ) {
        return calendarSetMemberService.delete(calendarSetId, calendarId);
    }
}
