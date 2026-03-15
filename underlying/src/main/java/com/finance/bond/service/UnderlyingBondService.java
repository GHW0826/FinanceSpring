package com.finance.bond.service;

import com.finance.common.underlying.entity.UnderlyingBond;
import com.finance.bond.repository.UnderlyingBondRepository;
import com.finance.common.underlying.dto.DeleteUnderlyingBondResponse;
import com.finance.common.underlying.dto.GetUnderlyingBondResponse;
import com.finance.common.underlying.dto.SaveUnderlyingBondRequest;
import com.finance.common.underlying.dto.SaveUnderlyingBondResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UnderlyingBondService {
//    private final UnderlyingBondRepository underlyingBondRepository;
//
//    public UnderlyingBondService(UnderlyingBondRepository underlyingBondRepository) {
//        this.underlyingBondRepository = underlyingBondRepository;
//    }
//
//    public List<GetUnderlyingBondResponse> getAllBonds() {
//        List<UnderlyingBond> bonds = underlyingBondRepository.findAll();
//        return new ArrayList<GetUnderlyingBondResponse>();
//    }
//
//    public GetUnderlyingBondResponse getBondByMdCd(String mdCd) {
//        // mdCd 기준 단건 반환
//        UnderlyingBond bond = underlyingBondRepository.findByUnderlyingCd(mdCd)
//                .orElseThrow();
//        // 예시용: return
//        return new GetUnderlyingBondResponse();
//    }
//
//
//    public SaveUnderlyingBondResponse save(SaveUnderlyingBondRequest dto) {
//        UnderlyingBond bond = new UnderlyingBond(
//        );
//        underlyingBondRepository.save(bond);
//        return null;
//    }
//
//    public DeleteUnderlyingBondResponse delete(String mdCd) {
//        underlyingBondRepository.deleteById(mdCd);
//        return new DeleteUnderlyingBondResponse();
//    }
}