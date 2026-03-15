package com.finance.common.market.dto.bondcurvepoint;

import com.finance.common.enums.BondCurvePointQuality;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PutBondCurvePointResponse(
        Long id,
        Long snapshotId,
        LocalDate pillarDate,
        String tenorLabel,
        BigDecimal ytmValue,
        BigDecimal zeroRateValue,
        BigDecimal discountFactorValue,
        BigDecimal instantForwardRateValue,
        boolean extrapolated,
        BondCurvePointQuality pointQuality
) { }

