package com.finance.common.reference.dto.vendor;

public record GetVendorResponse(
        Long vendorId,
        String vendorCode,
        String name,
        String homepageUrl,
        boolean active,
        String description
) { }
