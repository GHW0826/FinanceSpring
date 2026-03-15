package com.finance.bond.service;

import com.finance.bond.repository.BondCurveBuildMethodRepository;
import com.finance.common.market.dto.bondcurvebuildmethod.CreateBondCurveBuildMethodRequest;
import com.finance.common.market.dto.bondcurvebuildmethod.CreateBondCurveBuildMethodResponse;
import com.finance.common.market.dto.bondcurvebuildmethod.GetBondCurveBuildMethodResponse;
import com.finance.common.market.entity.bond.BondCurveBuildMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BondCurveBuildMethodService {
    private final BondCurveBuildMethodRepository bondRepo;

    public CreateBondCurveBuildMethodResponse create(CreateBondCurveBuildMethodRequest req) {
        return new CreateBondCurveBuildMethodResponse(
                null,
                req.buildMethodCode(),
                req.name(),
                req.fittingMethod(),
                req.interpolationMethod(),
                req.extrapolationMethod(),
                req.dayCountConvention(),
                req.compoundingType(),
                req.compoundingFrequency(),
                req.businessDayConvention(),
                req.calendarId(),
                req.settlementDays(),
                req.active() != null ? req.active() : true,
                req.description()
        );
    }

    @Transactional(readOnly = true)
    public GetBondCurveBuildMethodResponse get(Long id) {
        BondCurveBuildMethod buildMethod = bondRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        return new GetBondCurveBuildMethodResponse(
                buildMethod.getId(),
                buildMethod.getBuildMethodCode(),
                buildMethod.getName(),
                buildMethod.getFittingMethod(),
                buildMethod.getInterpolationMethod(),
                buildMethod.getExtrapolationMethod(),
                buildMethod.getDayCountConvention(),
                buildMethod.getCompoundingType(),
                buildMethod.getCompoundingFrequency(),
                buildMethod.getBusinessDayConvention(),
                buildMethod.getCalendar() != null ? buildMethod.getCalendar().getId() : null,
                buildMethod.getSettlementDays(),
                buildMethod.isActive(),
                buildMethod.getDescription()
        );
    }
}
