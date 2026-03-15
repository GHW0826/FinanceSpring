package com.finance.common.reference.dto.country;

public record CreateCountryRequest(
        String countryIso2,
        String countryIso3,
        String numericCode,
        String name,
        String timezone,
        Boolean active,
        String description
) {
}