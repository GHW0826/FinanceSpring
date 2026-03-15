package com.finance.common.common.dto.sensitivity;

import java.util.List;

public record GetSensitivityAllResponse(
        List<GetSensitivityResponse> items
) { }

