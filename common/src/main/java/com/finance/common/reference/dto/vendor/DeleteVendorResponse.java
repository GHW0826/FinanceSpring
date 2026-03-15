package com.finance.common.reference.dto.vendor;

public record DeleteVendorResponse(
        Long id,
        boolean deleted
) { }