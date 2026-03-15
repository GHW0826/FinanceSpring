package com.finance.common.common.dto.instrumentgroup;

public record DeleteInstrumentGroupResponse(
        String code,
        boolean deleted
) { }

