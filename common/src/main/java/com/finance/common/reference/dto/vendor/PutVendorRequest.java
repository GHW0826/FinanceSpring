package com.finance.common.reference.dto.vendor;

public record PutVendorRequest(
        String vendorCode,
        String name,
        String homepageUrl,
        Boolean active,
        String description
) { }
