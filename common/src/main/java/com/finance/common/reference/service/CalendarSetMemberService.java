package com.finance.common.reference.service;

import com.finance.common.reference.dto.calendar.calendarsetmember.*;
import com.finance.common.reference.entity.calendar.Calendar;
import com.finance.common.reference.entity.calendar.CalendarSet;
import com.finance.common.reference.entity.calendar.CalendarSetMember;
import com.finance.common.reference.entity.calendar.CalendarSetMemberId;
import com.finance.common.reference.mapper.CalendarSetMemberMapper;
import com.finance.common.reference.repository.CalendarRepository;
import com.finance.common.reference.repository.CalendarSetMemberRepository;
import com.finance.common.reference.repository.CalendarSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarSetMemberService {

    private final CalendarSetMemberRepository calendarSetMemberRepository;
    private final CalendarSetRepository calendarSetRepository;
    private final CalendarRepository calendarRepository;
    private final CalendarSetMemberMapper mapper;

    private CalendarSetMember getEntity(Long calendarSetId, Long calendarId) {
        CalendarSetMemberId id = new CalendarSetMemberId(calendarSetId, calendarId);
        return calendarSetMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "CalendarSetMember not found. calendarSetId=" + calendarSetId + ", calendarId=" + calendarId
                ));
    }

    private CalendarSet getCalendarSet(Long calendarSetId) {
        return calendarSetRepository.findById(calendarSetId)
                .orElseThrow(() -> new IllegalArgumentException("CalendarSet not found. id=" + calendarSetId));
    }

    private Calendar getCalendar(Long calendarId) {
        return calendarRepository.findById(calendarId)
                .orElseThrow(() -> new IllegalArgumentException("Calendar not found. id=" + calendarId));
    }

    public CreateCalendarSetMemberResponse create(CreateCalendarSetMemberRequest request) {
        CalendarSetMemberId id = new CalendarSetMemberId(request.calendarSetId(), request.calendarId());
        if (calendarSetMemberRepository.existsById(id)) {
            throw new IllegalArgumentException(
                    "CalendarSetMember already exists. calendarSetId=" + request.calendarSetId()
                            + ", calendarId=" + request.calendarId()
            );
        }

        CalendarSetMember entity = mapper.toEntity(request);
        entity.setId(id);
        entity.setCalendarSet(getCalendarSet(request.calendarSetId()));
        entity.setCalendar(getCalendar(request.calendarId()));

        CalendarSetMember saved = calendarSetMemberRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetCalendarSetMemberResponse get(Long calendarSetId, Long calendarId) {
        CalendarSetMember entity = getEntity(calendarSetId, calendarId);
        return mapper.toGetResponse(entity);
    }

    public GetCalendarSetMemberAllResponse getAll(Long calendarSetId) {
        List<CalendarSetMember> entities =
                calendarSetMemberRepository.findAllByCalendarSet_IdOrderBySeqNoAscCalendar_IdAsc(calendarSetId);
        List<GetCalendarSetMemberResponse> items = mapper.toGetResponseList(entities);
        return new GetCalendarSetMemberAllResponse(items);
    }

    public UpdateCalendarSetMemberResponse update(
            Long calendarSetId,
            Long calendarId,
            UpdateCalendarSetMemberRequest request
    ) {
        CalendarSetMember entity = getEntity(calendarSetId, calendarId);
        entity.update(request.seqNo());
        CalendarSetMember saved = calendarSetMemberRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    public PutCalendarSetMemberResponse put(
            Long calendarSetId,
            Long calendarId,
            PutCalendarSetMemberRequest request
    ) {
        CalendarSetMember entity = getEntity(calendarSetId, calendarId);
        entity.put(request.seqNo());
        CalendarSetMember saved = calendarSetMemberRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    public DeleteCalendarSetMemberResponse delete(Long calendarSetId, Long calendarId) {
        CalendarSetMemberId id = new CalendarSetMemberId(calendarSetId, calendarId);
        boolean exists = calendarSetMemberRepository.existsById(id);
        if (exists) {
            calendarSetMemberRepository.deleteById(id);
        }
        return new DeleteCalendarSetMemberResponse(calendarSetId, calendarId, exists);
    }
}
