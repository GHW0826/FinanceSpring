package com.finance.common.reference.service;

import com.finance.common.reference.dto.calendar.calendarweekend.*;
import com.finance.common.reference.entity.calendar.Calendar;
import com.finance.common.reference.entity.calendar.CalendarWeekend;
import com.finance.common.reference.entity.calendar.CalendarWeekendId;
import com.finance.common.reference.entity.calendar.WeekendProfile;
import com.finance.common.reference.mapper.CalendarWeekendMapper;
import com.finance.common.reference.repository.CalendarRepository;
import com.finance.common.reference.repository.CalendarWeekendRepository;
import com.finance.common.reference.repository.WeekendProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarWeekendService {

    private final CalendarWeekendRepository calendarWeekendRepository;
    private final CalendarRepository calendarRepository;
    private final WeekendProfileRepository weekendProfileRepository;
    private final CalendarWeekendMapper mapper;

    private CalendarWeekend getEntity(Long calendarId, LocalDate validFrom) {
        CalendarWeekendId id = new CalendarWeekendId(calendarId, validFrom);
        return calendarWeekendRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "CalendarWeekend not found. calendarId=" + calendarId + ", validFrom=" + validFrom
                ));
    }

    private Calendar getCalendar(Long calendarId) {
        return calendarRepository.findById(calendarId)
                .orElseThrow(() -> new IllegalArgumentException("Calendar not found. id=" + calendarId));
    }

    private WeekendProfile getWeekendProfile(Long weekendProfileId) {
        return weekendProfileRepository.findById(weekendProfileId)
                .orElseThrow(() -> new IllegalArgumentException("WeekendProfile not found. id=" + weekendProfileId));
    }

    public CreateCalendarWeekendResponse create(CreateCalendarWeekendRequest request) {
        CalendarWeekendId id = new CalendarWeekendId(request.calendarId(), request.validFrom());
        if (calendarWeekendRepository.existsById(id)) {
            throw new IllegalArgumentException(
                    "CalendarWeekend already exists. calendarId=" + request.calendarId()
                            + ", validFrom=" + request.validFrom()
            );
        }

        CalendarWeekend entity = mapper.toEntity(request);
        entity.setId(id);
        entity.setCalendar(getCalendar(request.calendarId()));
        entity.setWeekendProfile(getWeekendProfile(request.weekendProfileId()));

        CalendarWeekend saved = calendarWeekendRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetCalendarWeekendResponse get(Long calendarId, LocalDate validFrom) {
        CalendarWeekend entity = getEntity(calendarId, validFrom);
        return mapper.toGetResponse(entity);
    }

    public GetCalendarWeekendAllResponse getAll(Long calendarId) {
        List<CalendarWeekend> entities = calendarWeekendRepository.findAllByCalendar_IdOrderById_ValidFromAsc(calendarId);
        List<GetCalendarWeekendResponse> items = mapper.toGetResponseList(entities);
        return new GetCalendarWeekendAllResponse(items);
    }

    public UpdateCalendarWeekendResponse update(
            Long calendarId,
            LocalDate validFrom,
            UpdateCalendarWeekendRequest request
    ) {
        CalendarWeekend entity = getEntity(calendarId, validFrom);
        WeekendProfile weekendProfile = null;
        if (request.weekendProfileId() != null) {
            weekendProfile = getWeekendProfile(request.weekendProfileId());
        }
        entity.update(request.validTo(), weekendProfile);
        CalendarWeekend saved = calendarWeekendRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    public PutCalendarWeekendResponse put(
            Long calendarId,
            LocalDate validFrom,
            PutCalendarWeekendRequest request
    ) {
        CalendarWeekend entity = getEntity(calendarId, validFrom);
        WeekendProfile weekendProfile = getWeekendProfile(request.weekendProfileId());
        entity.put(request.validTo(), weekendProfile);
        CalendarWeekend saved = calendarWeekendRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    public DeleteCalendarWeekendResponse delete(Long calendarId, LocalDate validFrom) {
        CalendarWeekendId id = new CalendarWeekendId(calendarId, validFrom);
        boolean exists = calendarWeekendRepository.existsById(id);
        if (exists) {
            calendarWeekendRepository.deleteById(id);
        }
        return new DeleteCalendarWeekendResponse(calendarId, validFrom, exists);
    }
}
