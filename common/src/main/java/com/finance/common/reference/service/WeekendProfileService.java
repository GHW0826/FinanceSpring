package com.finance.common.reference.service;

import com.finance.common.reference.dto.calendar.weekendprofile.*;
import com.finance.common.reference.entity.calendar.WeekendProfile;
import com.finance.common.reference.mapper.WeekendProfileMapper;
import com.finance.common.reference.repository.WeekendProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WeekendProfileService {

    private final WeekendProfileRepository weekendProfileRepository;
    private final WeekendProfileMapper mapper;

    private WeekendProfile getEntity(Long id) {
        return weekendProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("WeekendProfile not found. id=" + id));
    }

    public CreateWeekendProfileResponse create(CreateWeekendProfileRequest request) {
        WeekendProfile entity = mapper.toEntity(request);
        WeekendProfile saved = weekendProfileRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetWeekendProfileResponse get(Long id) {
        WeekendProfile entity = getEntity(id);
        return mapper.toGetResponse(entity);
    }

    public GetWeekendProfileAllResponse getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "profileCode");
        List<WeekendProfile> weekendProfiles = weekendProfileRepository.findAll(sort);
        List<GetWeekendProfileResponse> items = mapper.toGetResponseList(weekendProfiles);
        return new GetWeekendProfileAllResponse(items);
    }

    public UpdateWeekendProfileResponse update(Long id, UpdateWeekendProfileRequest request) {
        WeekendProfile entity = getEntity(id);
        entity.update(request.profileCode(), request.description());
        WeekendProfile saved = weekendProfileRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    public PutWeekendProfileResponse put(Long id, PutWeekendProfileRequest request) {
        WeekendProfile entity = getEntity(id);
        entity.put(request.profileCode(), request.description());
        WeekendProfile saved = weekendProfileRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    public DeleteWeekendProfileResponse delete(Long id) {
        boolean exists = weekendProfileRepository.existsById(id);
        if (exists) {
            weekendProfileRepository.deleteById(id);
        }
        return new DeleteWeekendProfileResponse(id, exists);
    }
}
