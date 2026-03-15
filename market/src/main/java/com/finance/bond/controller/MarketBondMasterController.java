package com.finance.bond.controller;

import com.finance.bond.service.MarketBondMasterService;
import com.finance.common.market.dto.bond.CreateMarketBondRequest;
import com.finance.common.market.dto.bond.CreateMarketBondResponse;
import com.finance.common.market.dto.bond.DeleteMarketBondResponse;
import com.finance.common.market.dto.bond.GetMarketBondResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/market/bond")
public class MarketBondMasterController {
    private final MarketBondMasterService marketDataBondMasterService;

    public MarketBondMasterController(MarketBondMasterService marketDataBondMasterService) {
        this.marketDataBondMasterService = marketDataBondMasterService;
    }

    @DeleteMapping("/{mdCd}")
    public DeleteMarketBondResponse delete(@PathVariable String mdCd) {
        return marketDataBondMasterService.delete(mdCd);
    }

    // mdCd로 단건 조회
    @GetMapping("/{mdCd}")
    public GetMarketBondResponse getBondByMdCd(@PathVariable String mdCd) {
        return marketDataBondMasterService.getBondByMarketDataCode(mdCd);
    }
    // 등록
    @PostMapping("/")
    public CreateMarketBondResponse create(@RequestBody CreateMarketBondRequest bond) {
        return marketDataBondMasterService.create(bond);
    }

    @GetMapping("/")
    public List<GetMarketBondResponse> getAllBonds() {
        return marketDataBondMasterService.getAllBonds();
    }

}
