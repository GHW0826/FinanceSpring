package com.finance.common.reference.repository;

import com.finance.common.reference.entity.calendar.CalendarException;
import com.finance.common.reference.entity.calendar.CalendarExceptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarExceptionRepository extends JpaRepository<CalendarException, CalendarExceptionId> {
    List<CalendarException> findAllByCalendar_IdOrderByCalendarExceptionId_ExceptionDateAsc(Long calendarId);
}