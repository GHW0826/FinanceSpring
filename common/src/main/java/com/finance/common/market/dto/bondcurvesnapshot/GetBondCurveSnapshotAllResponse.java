package com.finance.common.market.dto.bondcurvesnapshot;

import java.util.List;

public record GetBondCurveSnapshotAllResponse(
        List<GetBondCurveSnapshotResponse> items
) { }

