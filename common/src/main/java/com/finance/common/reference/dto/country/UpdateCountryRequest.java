package com.finance.common.reference.dto.country;

public record UpdateCountryRequest(
        String countryIso2,
        String countryIso3,
        String numericCode,
        String name,
        String timezone,
        Boolean active,
        String description
) {
}