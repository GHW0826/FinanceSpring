package com.finance.common.common.dto.agreement;

import java.math.BigDecimal;

public record CreateAgreementRequest(
        BigDecimal threshold,
        BigDecimal minimumTransferAmount,
        BigDecimal haircut
) { }


