package com.finance.bond.controller;

import com.finance.bond.service.UnderlyingBondService;
import com.finance.common.underlying.dto.DeleteUnderlyingBondResponse;
import com.finance.common.underlying.dto.GetUnderlyingBondResponse;
import com.finance.common.underlying.dto.SaveUnderlyingBondRequest;
import com.finance.common.underlying.dto.SaveUnderlyingBondResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/underlying")
public class UnderlyingBondController {
//    private final UnderlyingBondService underlyingBondService;
//
//    public UnderlyingBondController(UnderlyingBondService underlyingBondService) {
//        this.underlyingBondService = underlyingBondService;
//    }
//
//    @GetMapping("/bond")
//    public List<GetUnderlyingBondResponse> getAllBonds() {
//        return underlyingBondService.getAllBonds();
//    }
//
//    // mdCd로 단건 조회
//    @GetMapping("/bond/{underlyingCd}")
//    public GetUnderlyingBondResponse getBondByMdCd(@PathVariable String underlyingCd) {
//        return underlyingBondService.getBondByMdCd(underlyingCd);
//    }
//
//    // 등록
//    @PostMapping("/bond")
//    public SaveUnderlyingBondResponse save (@RequestBody SaveUnderlyingBondRequest bond) {
//        return underlyingBondService.save(bond);
//    }
//
//    @DeleteMapping("/bond/{underlyingCd}")
//    public DeleteUnderlyingBondResponse delete(@PathVariable String underlyingCd) {
//        return underlyingBondService.delete(underlyingCd);
//    }
}
