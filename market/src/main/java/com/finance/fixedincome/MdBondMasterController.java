package com.finance.fixedincome;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MdBondMasterController {
    private final MdBondMasterService mdBondMasterService;

    public MdBondMasterController(MdBondMasterService mdBondMasterService) {
        this.mdBondMasterService = mdBondMasterService;
    }

    @GetMapping("/bond")
    public List<GetMarketBondResponse> getAllBonds() {
        return mdBondMasterService.getAllBonds();
    }

    // mdCd로 단건 조회
    @GetMapping("/bond/{mdCd}")
    public GetMarketBondResponse getBondByMdCd(@PathVariable String mdCd) {
        return mdBondMasterService.getBondByMdCd(mdCd);
    }

    // 등록
    @PostMapping("/bond")
    public CreateMarketBondResponse create(@RequestBody CreateMarketBondRequest bond) {
        return mdBondMasterService.create(bond);
    }

    @DeleteMapping("/bond/{mdCd}")
    public DeleteMarketBondResponse delete(@PathVariable String mdCd) {
        return mdBondMasterService.delete(mdCd);
    }
}
