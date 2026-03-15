package com.finance.common.reference.repository;

import com.finance.common.reference.entity.calendar.CalendarSetMember;
import com.finance.common.reference.entity.calendar.CalendarSetMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarSetMemberRepository extends JpaRepository<CalendarSetMember, CalendarSetMemberId> {
    List<CalendarSetMember> findAllByCalendarSet_IdOrderBySeqNoAscCalendar_IdAsc(Long calendarSetId);
}
