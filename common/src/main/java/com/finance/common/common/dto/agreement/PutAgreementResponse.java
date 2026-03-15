package com.finance.common.common.dto.agreement;

import java.math.BigDecimal;

public record PutAgreementResponse(
        Long id,
        BigDecimal threshold,
        BigDecimal minimumTransferAmount,
        BigDecimal haircut
) { }

