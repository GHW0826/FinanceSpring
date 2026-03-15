package com.finance.common.reference.dto.vendor;

public record CreateVendorRequest(
        String vendorCode,
        String name,
        String homepageUrl,
        Boolean active,
        String description
) { }
