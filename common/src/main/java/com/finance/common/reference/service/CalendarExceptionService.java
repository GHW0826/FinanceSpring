package com.finance.common.reference.service;

import com.finance.common.reference.dto.calendar.calendarexception.*;
import com.finance.common.reference.entity.calendar.Calendar;
import com.finance.common.reference.entity.calendar.CalendarException;
import com.finance.common.reference.entity.calendar.CalendarExceptionId;
import com.finance.common.reference.mapper.CalendarExceptionMapper;
import com.finance.common.reference.repository.CalendarExceptionRepository;
import com.finance.common.reference.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarExceptionService {
    private final CalendarExceptionRepository calendarExceptionRepository;
    private final CalendarRepository calendarRepository;
    private final CalendarExceptionMapper mapper;

    private CalendarException getEntity(Long calendarId, LocalDate exceptionDate) {
        CalendarExceptionId id = new CalendarExceptionId(calendarId, exceptionDate);
        return calendarExceptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "CalendarException not found. calendarId=" + calendarId + ", exceptionDate=" + exceptionDate
                ));
    }

    private Calendar getCalendar(Long calendarId) {
        return calendarRepository.findById(calendarId)
                .orElseThrow(() -> new IllegalArgumentException("Calendar not found. id=" + calendarId));
    }

    @Transactional
    public CreateCalendarExceptionResponse create(CreateCalendarExceptionRequest request) {
        Calendar calendar = getCalendar(request.calendarId());
        CalendarExceptionId id = new CalendarExceptionId(request.calendarId(), request.exceptionDate());

        if (calendarExceptionRepository.existsById(id)) {
            throw new IllegalArgumentException(
                    "CalendarException already exists. calendarId=" + request.calendarId()
                            + ", exceptionDate=" + request.exceptionDate()
            );
        }

        CalendarException entity = mapper.toEntity(request);
        entity.setCalendar(calendar);
        entity.setCalendarExceptionId(id);

        CalendarException saved = calendarExceptionRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetCalendarExceptionResponse get(Long calendarId, LocalDate exceptionDate) {
        CalendarException entity = getEntity(calendarId, exceptionDate);
        return mapper.toGetResponse(entity);
    }

    public GetCalendarExceptionAllResponse getAll(Long calendarId) {
        List<CalendarException> entities =
                calendarExceptionRepository.findAllByCalendar_IdOrderByCalendarExceptionId_ExceptionDateAsc(calendarId);

        List<GetCalendarExceptionResponse> items = mapper.toGetResponseList(entities);
        return new GetCalendarExceptionAllResponse(items);
    }

    @Transactional
    public UpdateCalendarExceptionResponse update(
            Long calendarId,
            LocalDate exceptionDate,
            UpdateCalendarExceptionRequest request
    ) {
        CalendarException entity = getEntity(calendarId, exceptionDate);

        entity.update(
                request.businessDay(),
                request.exceptionType(),
                request.exceptionName(),
                request.observedOf(),
                request.source()
        );

        CalendarException saved = calendarExceptionRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    @Transactional
    public PutCalendarExceptionResponse put(
            Long calendarId,
            LocalDate exceptionDate,
            PutCalendarExceptionRequest request
    ) {
        CalendarException entity = getEntity(calendarId, exceptionDate);

        entity.put(
                request.businessDay(),
                request.exceptionType(),
                request.exceptionName(),
                request.observedOf(),
                request.source()
        );

        CalendarException saved = calendarExceptionRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    @Transactional
    public DeleteCalendarExceptionResponse delete(Long calendarId, LocalDate exceptionDate) {
        CalendarExceptionId id = new CalendarExceptionId(calendarId, exceptionDate);
        boolean exists = calendarExceptionRepository.existsById(id);

        if (exists) {
            calendarExceptionRepository.deleteById(id);
        }

        return new DeleteCalendarExceptionResponse(calendarId, exceptionDate, exists);
    }
}
