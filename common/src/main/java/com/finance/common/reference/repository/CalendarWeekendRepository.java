package com.finance.common.reference.repository;

import com.finance.common.reference.entity.calendar.CalendarWeekend;
import com.finance.common.reference.entity.calendar.CalendarWeekendId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarWeekendRepository extends JpaRepository<CalendarWeekend, CalendarWeekendId> {
    List<CalendarWeekend> findAllByCalendar_IdOrderById_ValidFromAsc(Long calendarId);
}
