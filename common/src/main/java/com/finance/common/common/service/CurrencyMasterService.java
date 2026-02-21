package com.finance.common.common.service;

import com.finance.common.common.dto.currency.CreateCurrencyRequest;
import com.finance.common.common.dto.currency.CreateCurrencyResponse;
import com.finance.common.common.dto.currency.DeleteCurrencyResponse;
import com.finance.common.common.dto.currency.GetCurrencyResponse;
import com.finance.common.common.entity.currency.CurrencyMaster;
import com.finance.common.common.mapper.currency.CurrencyMasterMapper;
import com.finance.common.common.repository.CurrencyMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CurrencyMasterService {

    private final CurrencyMasterRepository currencyMasterRepository;
    private final CurrencyMasterMapper mapper;

    // ccy 기준 단건 반환
    @Transactional(readOnly = true)
    public GetCurrencyResponse getCurrencyByCcy(String ccy) {
        CurrencyMaster currency = currencyMasterRepository.findById(ccy).orElseThrow();
        return mapper.toGetResponse(currency);
    }

    public DeleteCurrencyResponse delete(String ccy) {
        boolean exists = currencyMasterRepository.existsById(ccy);
        if (exists) {
            currencyMasterRepository.deleteById(ccy);
        }
        return new DeleteCurrencyResponse(ccy, exists);
    }

    public CreateCurrencyResponse create(CreateCurrencyRequest req) {
        CurrencyMaster entity = mapper.toEntity(req);
        CurrencyMaster saved = currencyMasterRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }
}