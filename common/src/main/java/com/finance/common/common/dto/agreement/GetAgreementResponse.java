package com.finance.common.common.dto.agreement;

import java.math.BigDecimal;

public record GetAgreementResponse(
        Long id,
        BigDecimal threshold,
        BigDecimal minimumTransferAmount,
        BigDecimal haircut
) { }

