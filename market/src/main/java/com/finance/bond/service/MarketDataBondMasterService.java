package com.finance.bond.service;

import com.finance.bond.repository.MarketDataBondMasterRepository;
import com.finance.common.market.dto.bond.CreateMarketBondRequest;
import com.finance.common.market.dto.bond.CreateMarketBondResponse;
import com.finance.common.market.dto.bond.DeleteMarketBondResponse;
import com.finance.common.market.dto.bond.GetMarketBondResponse;
import com.finance.common.common.entity.currency.CurrencyMaster;
import com.finance.common.market.entity.MarketDataBondMaster;
import com.finance.common.market.mapper.bond.MarketDataBondMapper;
import com.finance.common.common.repository.CurrencyMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketDataBondMasterService {
    private final MarketDataBondMasterRepository marketDataBondMasterRepository;
    private final CurrencyMasterRepository currencyMasterRepository;
    private final MarketDataBondMapper mapper;

    // mdCd 기준 단건 반환
    public GetMarketBondResponse getBondByMarketDataCode(String mdCd) {
        MarketDataBondMaster bond = marketDataBondMasterRepository.findByMarketDataCode(mdCd).orElseThrow();
        return new GetMarketBondResponse();
    }

    public DeleteMarketBondResponse delete(String mdCd) {
        marketDataBondMasterRepository.deleteByMarketDataCode(mdCd);
        return new DeleteMarketBondResponse();
    }

    @Transactional
    public CreateMarketBondResponse create(CreateMarketBondRequest req) {
        MarketDataBondMaster bond = mapper.toEntity(req);
        // 2) FK: 통화 세팅 (nullable=false/optional=false 이면 필수)
        //    - 즉시 존재 검증이 필요하면 findById().orElseThrow()
        //    - 성능이 더 중요하면 getReferenceById() (단, 없는 키면 flush 시점에 예외)
        CurrencyMaster currency = currencyMasterRepository.findById(req.Ccy())
                .orElseThrow(() -> new IllegalArgumentException("Unknown Ccy: " + req.Ccy()));
        bond.setCurrency(currency);

        MarketDataBondMaster saved = marketDataBondMasterRepository.save(bond);
        return mapper.toResponse(saved);
    }

    public List<GetMarketBondResponse> getAllBonds() {
        List<MarketDataBondMaster> bonds = marketDataBondMasterRepository.findAll();
        return new ArrayList<GetMarketBondResponse>();
    }
}