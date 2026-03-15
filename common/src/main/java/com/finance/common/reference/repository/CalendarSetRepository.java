package com.finance.common.reference.repository;

import com.finance.common.reference.entity.calendar.CalendarSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarSetRepository extends JpaRepository<CalendarSet, Long> {
}