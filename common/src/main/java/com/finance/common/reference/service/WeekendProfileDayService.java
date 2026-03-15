package com.finance.common.reference.service;

import com.finance.common.reference.dto.calendar.weekendprofileday.*;
import com.finance.common.reference.entity.calendar.WeekendProfile;
import com.finance.common.reference.entity.calendar.WeekendProfileDay;
import com.finance.common.reference.entity.calendar.WeekendProfileDayId;
import com.finance.common.reference.mapper.WeekendProfileDayMapper;
import com.finance.common.reference.repository.WeekendProfileDayRepository;
import com.finance.common.reference.repository.WeekendProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WeekendProfileDayService {

    private final WeekendProfileDayRepository weekendProfileDayRepository;
    private final WeekendProfileRepository weekendProfileRepository;
    private final WeekendProfileDayMapper mapper;

    private WeekendProfileDay getEntity(Long weekendProfileId, Short isoWeekday) {
        WeekendProfileDayId id = new WeekendProfileDayId(weekendProfileId, isoWeekday);
        return weekendProfileDayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "WeekendProfileDay not found. weekendProfileId=" + weekendProfileId
                                + ", isoWeekday=" + isoWeekday
                ));
    }

    private WeekendProfile getWeekendProfile(Long weekendProfileId) {
        return weekendProfileRepository.findById(weekendProfileId)
                .orElseThrow(() -> new IllegalArgumentException("WeekendProfile not found. id=" + weekendProfileId));
    }

    public CreateWeekendProfileDayResponse create(CreateWeekendProfileDayRequest request) {
        WeekendProfileDayId id = new WeekendProfileDayId(request.weekendProfileId(), request.isoWeekday());
        if (weekendProfileDayRepository.existsById(id)) {
            throw new IllegalArgumentException(
                    "WeekendProfileDay already exists. weekendProfileId=" + request.weekendProfileId()
                            + ", isoWeekday=" + request.isoWeekday()
            );
        }

        WeekendProfileDay entity = mapper.toEntity(request);
        entity.setId(id);
        entity.setWeekendProfile(getWeekendProfile(request.weekendProfileId()));

        WeekendProfileDay saved = weekendProfileDayRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetWeekendProfileDayResponse get(Long weekendProfileId, Short isoWeekday) {
        WeekendProfileDay entity = getEntity(weekendProfileId, isoWeekday);
        return mapper.toGetResponse(entity);
    }

    public GetWeekendProfileDayAllResponse getAll(Long weekendProfileId) {
        List<WeekendProfileDay> entities =
                weekendProfileDayRepository.findAllByWeekendProfile_IdOrderById_IsoWeekdayAsc(weekendProfileId);
        List<GetWeekendProfileDayResponse> items = mapper.toGetResponseList(entities);
        return new GetWeekendProfileDayAllResponse(items);
    }

    public UpdateWeekendProfileDayResponse update(
            Long weekendProfileId,
            Short isoWeekday,
            UpdateWeekendProfileDayRequest request
    ) {
        WeekendProfileDay entity = getEntity(weekendProfileId, isoWeekday);
        entity.update(request.weekend());
        WeekendProfileDay saved = weekendProfileDayRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    public PutWeekendProfileDayResponse put(
            Long weekendProfileId,
            Short isoWeekday,
            PutWeekendProfileDayRequest request
    ) {
        WeekendProfileDay entity = getEntity(weekendProfileId, isoWeekday);
        entity.put(request.weekend());
        WeekendProfileDay saved = weekendProfileDayRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    public DeleteWeekendProfileDayResponse delete(Long weekendProfileId, Short isoWeekday) {
        WeekendProfileDayId id = new WeekendProfileDayId(weekendProfileId, isoWeekday);
        boolean exists = weekendProfileDayRepository.existsById(id);
        if (exists) {
            weekendProfileDayRepository.deleteById(id);
        }
        return new DeleteWeekendProfileDayResponse(weekendProfileId, isoWeekday, exists);
    }
}
