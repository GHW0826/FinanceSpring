package com.finance.common.reference.service;

import com.finance.common.reference.dto.country.*;
import com.finance.common.reference.dto.currency.*;
import com.finance.common.reference.entity.Country;
import com.finance.common.reference.entity.CurrencyMaster;
import com.finance.common.reference.mapper.CountryMapper;
import com.finance.common.reference.mapper.CurrencyMasterMapper;
import com.finance.common.reference.repository.CountryRepository;
import com.finance.common.reference.repository.CurrencyMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CurrencyMasterService {

    private final CurrencyMasterRepository currencyMasterRepository;
    private final CurrencyMasterMapper mapper;

    private CurrencyMaster getEntity(Long id)
    {
        return currencyMasterRepository.findById(id).orElseThrow();
    }

    @Transactional
    public CreateCurrencyMasterResponse create(CreateCurrencyMasterRequest request) {
        CurrencyMaster entity = mapper.toEntity(request);
        CurrencyMaster saved = currencyMasterRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetCurrencyMasterResponse get(Long id) {
        CurrencyMaster entity = getEntity(id);
        return mapper.toGetResponse(entity);
    }

    public GetCurrencyMasterAllResponse getAll(Boolean active) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<CurrencyMaster> countries = currencyMasterRepository.findAll(sort);
        List<GetCurrencyMasterResponse> items = mapper.toGetResponseList(countries);
        return new GetCurrencyMasterAllResponse(items);
    }

    @Transactional
    public UpdateCurrencyMasterResponse update(Long id, UpdateCurrencyMasterRequest request) {
        CurrencyMaster entity = getEntity(id);
        entity.update(
                request.currencyCode(),
                request.name(),
                request.description()
        );
        CurrencyMaster saved = currencyMasterRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    @Transactional
    public PutCurrencyMasterResponse put(Long id, PutCurrencyMasterRequest request) {
        CurrencyMaster entity = getEntity(id);
        entity.update(
                request.currencyCode(),
                request.name(),
                request.description()
        );
        CurrencyMaster saved = currencyMasterRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    @Transactional
    public DeleteCurrencyMasterResponse delete(Long id) {
        boolean exists = currencyMasterRepository.existsById(id);
        if (exists) {
            currencyMasterRepository.deleteById(id);
        }
        return new DeleteCurrencyMasterResponse(id, exists);
    }
}