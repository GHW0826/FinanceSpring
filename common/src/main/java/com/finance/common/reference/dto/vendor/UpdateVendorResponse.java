package com.finance.common.reference.dto.vendor;

public record UpdateVendorResponse(
        Long vendorId,
        String vendorCode,
        String name,
        String homepageUrl,
        boolean active,
        String description
) { }
