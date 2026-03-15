package com.finance.common.common.dto.exposureprofile;

import java.util.List;

public record GetExposureProfileAllResponse(
        List<GetExposureProfileResponse> items
) { }

