package com.finance.bond.service;

import com.finance.bond.repository.BondCurveMasterRepository;
import com.finance.common.market.dto.bond.CreateBondCurveMasterRequest;
import com.finance.common.market.dto.bond.CreateBondCurveMasterResponse;
import com.finance.common.market.dto.bond.GetBondCurveMasterResponse;
import com.finance.common.market.entity.bond.BondCurve;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BondCurveMasterService {
    private final BondCurveMasterRepository bondRepo;

    public CreateBondCurveMasterResponse create(CreateBondCurveMasterRequest req) {
        return new CreateBondCurveMasterResponse(
                null,
                req.curveCode(),
                req.name(),
                req.currencyId(),
                req.curveType(),
                req.curvePurpose(),
                req.rateRepresentation(),
                req.active() != null ? req.active() : true,
                req.validFrom(),
                req.validTo(),
                req.description(),
                req.issuerId(),
                req.onTheRunOnly() != null ? req.onTheRunOnly() : false,
                req.minRemainingYears(),
                req.minOutstandingAmount(),
                req.outputIncludesYtm() != null ? req.outputIncludesYtm() : true,
                req.outputIncludesZero() != null ? req.outputIncludesZero() : true,
                req.outputIncludesDf() != null ? req.outputIncludesDf() : true
        );
    }

    @Transactional(readOnly = true)
    public GetBondCurveMasterResponse get(Long id) {
        BondCurve bondCurve = bondRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        return new GetBondCurveMasterResponse(
                bondCurve.getId(),
                bondCurve.getCurveCode(),
                bondCurve.getName(),
                bondCurve.getCurrency() != null ? bondCurve.getCurrency().getId() : null,
                bondCurve.getCurveType(),
                bondCurve.getCurvePurpose(),
                bondCurve.getRateRepresentation(),
                bondCurve.isActive(),
                bondCurve.getValidFrom(),
                bondCurve.getValidTo(),
                bondCurve.getDescription(),
                bondCurve.getIssuer() != null ? bondCurve.getIssuer().getId() : null,
                bondCurve.isOnTheRunOnly(),
                bondCurve.getMinRemainingYears(),
                bondCurve.getMinOutstandingAmount(),
                bondCurve.isOutputIncludesYtm(),
                bondCurve.isOutputIncludesZero(),
                bondCurve.isOutputIncludesDf()
        );
    }
}
