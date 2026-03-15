package com.finance.common.reference.service;

import com.finance.common.reference.dto.calendar.calendar.*;
import com.finance.common.reference.entity.Country;
import com.finance.common.reference.entity.calendar.Calendar;
import com.finance.common.reference.mapper.CalendarMapper;
import com.finance.common.reference.repository.CalendarRepository;
import com.finance.common.reference.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;
    private final CountryRepository countryRepository;
    private final CalendarMapper mapper;

    private Calendar getEntity(Long id)
    {
        return calendarRepository.findById(id).orElseThrow();
    }

    @Transactional
    public CreateCalendarResponse create(CreateCalendarRequest request) {
        Calendar entity = mapper.toEntity(request);
        Calendar saved = calendarRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetCalendarResponse get(Long id) {
        Calendar entity = getEntity(id);
        return mapper.toGetResponse(entity);
    }

    public GetCalendarAllResponse getAll(Boolean active) {
        Sort sort = Sort.by(Sort.Direction.ASC, "calendarName");
        List<Calendar> countries = (active == null)
                ? calendarRepository.findAll(sort)
                : calendarRepository.findAllByActive(active, sort);
        List<GetCalendarResponse> items = mapper.toGetResponseList(countries);
        return new GetCalendarAllResponse(items);
    }

    @Transactional
    public UpdateCalendarResponse update(Long id, UpdateCalendarRequest request) {
        Calendar entity = getEntity(id);
        Country country = null;
        if (request.countryId() != null) {
            country = getCountryOrNull(request.countryId());
        }
        entity.update(
            request.calendarCode(),
            request.calendarName(),
            request.calendarType(),
            country,
            request.regionCode(),
            request.timezone(),
            request.active()
        );
        Calendar saved = calendarRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    @Transactional
    public PutCalendarResponse put(Long id, PutCalendarRequest request) {
        Calendar entity = getEntity(id);
        Country country = null;
        if (request.countryId() != null) {
            country = getCountryOrNull(request.countryId());
        }
        entity.put(
            request.calendarCode(),
            request.calendarName(),
            request.calendarType(),
            country,
            request.regionCode(),
            request.timezone(),
            request.active()
        );
        Calendar saved = calendarRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    @Transactional
    public DeleteCalendarResponse delete(Long id) {
        boolean exists = calendarRepository.existsById(id);
        if (exists) {
            calendarRepository.deleteById(id);
        }
        return new DeleteCalendarResponse(id, exists);
    }

    private Country getCountryOrNull(Long countryId) {
        if (countryId == null) {
            return null;
        }
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new IllegalArgumentException("Country not found. id=" + countryId));
    }
}