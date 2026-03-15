package com.finance.bond.service;

import com.finance.bond.repository.MarketBondMasterRepository;
import com.finance.common.market.dto.bond.CreateMarketBondRequest;
import com.finance.common.market.dto.bond.CreateMarketBondResponse;
import com.finance.common.market.dto.bond.DeleteMarketBondResponse;
import com.finance.common.market.dto.bond.GetMarketBondResponse;
import com.finance.common.market.entity.bond.MarketBond;
import com.finance.common.reference.repository.CurrencyMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketBondMasterService {
    private final MarketBondMasterRepository marketDataBondMasterRepository;
    private final CurrencyMasterRepository currencyMasterRepository;
    // private final MarketDataBondMapper mapper;

    // mdCd 기준 단건 반환
    public GetMarketBondResponse getBondByMarketDataCode(String mdCd) {
        MarketBond bond = marketDataBondMasterRepository.findByMarketCode(mdCd).orElseThrow();
        return toResponse(bond);
    }

    public DeleteMarketBondResponse delete(String mdCd) {
        long deleted = marketDataBondMasterRepository.deleteByMarketCode(mdCd);
        return new DeleteMarketBondResponse(mdCd, deleted > 0);
    }

    @Transactional
    public CreateMarketBondResponse create(CreateMarketBondRequest req) {
       // MarketBondMaster bond = mapper.toEntity(req);
        // 2) FK: 통화 세팅 (nullable=false/optional=false 이면 필수)
        //    - 즉시 존재 검증이 필요하면 findById().orElseThrow()
        //    - 성능이 더 중요하면 getReferenceById() (단, 없는 키면 flush 시점에 예외)
//        CurrencyMaster currency = currencyMasterRepository.findById(req.Ccy())
//                .orElseThrow(() -> new IllegalArgumentException("Unknown Ccy: " + req.Ccy()));
        // bond.setCurrency(currency);

        //MarketBondMaster saved = marketDataBondMasterRepository.save(bond);
        //return mapper.toResponse(saved);
        return null;
    }

    public List<GetMarketBondResponse> getAllBonds() {
        List<MarketBond> bonds = marketDataBondMasterRepository.findAll();
        return new ArrayList<GetMarketBondResponse>();
    }

    private GetMarketBondResponse toResponse(MarketBond bond) {
        return new GetMarketBondResponse(
                bond.getId(),
                bond.getMarketCode(),
                bond.getVendor() != null ? bond.getVendor().getId() : null,
                bond.getName(),
                bond.getCurrency() != null ? bond.getCurrency().getId() : null,
                bond.getDefaultTradingContext() != null ? bond.getDefaultTradingContext().getId() : null,
                bond.getDefaultValuationContext() != null ? bond.getDefaultValuationContext().getId() : null,
                bond.getDescription(),
                bond.getIsin(),
                bond.getIssuer() != null ? bond.getIssuer().getId() : null,
                bond.getIssueDate(),
                bond.getMaturityDate(),
                bond.getCouponType(),
                bond.getCouponRate(),
                bond.getCouponFrequency(),
                bond.getDayCountConvention(),
                bond.getFaceValue(),
                bond.getRedemption()
        );
    }
}
