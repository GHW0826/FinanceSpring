package com.finance.common.reference.repository;

import com.finance.common.reference.entity.calendar.WeekendProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekendProfileRepository extends JpaRepository<WeekendProfile, Long> {
}
