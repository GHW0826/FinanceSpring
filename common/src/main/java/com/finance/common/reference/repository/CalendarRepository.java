package com.finance.common.reference.repository;

import com.finance.common.reference.entity.calendar.Calendar;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findAllByActive(boolean active, Sort sort);
}
