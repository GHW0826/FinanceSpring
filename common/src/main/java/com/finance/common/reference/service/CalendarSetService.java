package com.finance.common.reference.service;

import com.finance.common.reference.dto.calendar.calendarexception.*;
import com.finance.common.reference.dto.calendar.calendarset.*;
import com.finance.common.reference.entity.calendar.CalendarSet;
import com.finance.common.reference.mapper.CalendarSetMapper;
import com.finance.common.reference.repository.CalendarSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarSetService {

    private final CalendarSetRepository calendarSetRepository;
    private final CalendarSetMapper mapper;

    private CalendarSet getEntity(Long id) {
        return calendarSetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CalendarSet not found. id=" + id));
    }

    @Transactional
    public CreateCalendarSetResponse create(CreateCalendarSetRequest request) {
        CalendarSet entity = mapper.toEntity(request);
        CalendarSet saved = calendarSetRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetCalendarSetResponse get(Long id) {
        CalendarSet entity = getEntity(id);
        return mapper.toGetResponse(entity);
    }

    public GetCalendarSetAllResponse getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "setCode");
        List<CalendarSet> calendarSets = calendarSetRepository.findAll(sort);
        List<GetCalendarSetResponse> items = mapper.toGetResponseList(calendarSets);
        return new GetCalendarSetAllResponse(items);
    }

    @Transactional
    public UpdateCalendarSetResponse update(Long id, UpdateCalendarSetRequest request) {
        CalendarSet entity = getEntity(id);
        entity.update(
                request.setCode(),
                request.joinRule(),
                request.description()
        );
        CalendarSet saved = calendarSetRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    @Transactional
    public PutCalendarSetResponse put(Long id, PutCalendarSetRequest request) {
        CalendarSet entity = getEntity(id);
        entity.put(
                request.setCode(),
                request.joinRule(),
                request.description()
        );
        CalendarSet saved = calendarSetRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    @Transactional
    public DeleteCalendarSetResponse delete(Long id) {
        boolean exists = calendarSetRepository.existsById(id);
        if (exists) {
            calendarSetRepository.deleteById(id);
        }
        return new DeleteCalendarSetResponse(id, exists);
    }
}