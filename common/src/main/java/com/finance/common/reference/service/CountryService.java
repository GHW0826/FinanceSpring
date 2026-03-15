package com.finance.common.reference.service;

import com.finance.common.reference.dto.country.*;
import com.finance.common.reference.dto.vendor.DeleteVendorResponse;
import com.finance.common.reference.entity.Country;
import com.finance.common.reference.entity.calendar.Calendar;
import com.finance.common.reference.mapper.CountryMapper;
import com.finance.common.reference.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    private Country getEntity(Long id)
    {
        return countryRepository.findById(id).orElseThrow();
    }

    @Transactional
    public CreateCountryResponse create(CreateCountryRequest request) {
        Country entity = mapper.toEntity(request);
        Country saved = countryRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetCountryResponse get(Long id) {
        Country entity = getEntity(id);
        return mapper.toGetResponse(entity);
    }

    public GetCountryAllResponse getAll(Boolean active) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<Country> countries = (active == null)
                ? countryRepository.findAll(sort)
                : countryRepository.findAllByActive(active, sort);
        List<GetCountryResponse> items = mapper.toGetResponseList(countries);
        return new GetCountryAllResponse(items);
    }

    @Transactional
    public UpdateCountryResponse update(Long id, UpdateCountryRequest request) {
        Country entity = getEntity(id);
        entity.update(
                request.countryIso2(),
                request.countryIso3(),
                request.numericCode(),
                request.name(),
                request.timezone(),
                request.active(),
                request.description()
        );
        Country saved = countryRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    @Transactional
    public PutCountryResponse put(Long id, PutCountryRequest request) {
        Country entity = getEntity(id);
        entity.update(
                request.countryIso2(),
                request.countryIso3(),
                request.numericCode(),
                request.name(),
                request.timezone(),
                request.active(),
                request.description()
        );
        Country saved = countryRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    @Transactional
    public DeleteCountryResponse delete(Long id) {
        boolean exists = countryRepository.existsById(id);
        if (exists) {
            countryRepository.deleteById(id);
        }
        return new DeleteCountryResponse(id, exists);
    }
}