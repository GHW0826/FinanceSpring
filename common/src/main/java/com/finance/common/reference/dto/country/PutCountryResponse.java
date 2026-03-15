package com.finance.common.reference.dto.country;

public record PutCountryResponse(
        Long id,
        String countryIso2,
        String countryIso3,
        String numericCode,
        String name,
        String timezone,
        boolean active,
        String description
) {
}