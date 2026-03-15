package com.finance.common.reference.repository;

import com.finance.common.reference.entity.calendar.WeekendProfileDay;
import com.finance.common.reference.entity.calendar.WeekendProfileDayId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeekendProfileDayRepository extends JpaRepository<WeekendProfileDay, WeekendProfileDayId> {
    List<WeekendProfileDay> findAllByWeekendProfile_IdOrderById_IsoWeekdayAsc(Long weekendProfileId);
}
