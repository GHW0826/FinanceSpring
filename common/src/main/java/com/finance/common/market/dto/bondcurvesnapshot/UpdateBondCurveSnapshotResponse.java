package com.finance.common.market.dto.bondcurvesnapshot;

import com.finance.common.enums.SnapshotStatus;
import com.finance.common.enums.SnapshotType;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public record UpdateBondCurveSnapshotResponse(
        Long id,
        Long curveId,
        LocalDate valuationDate,
        Instant asOfTimestamp,
        String timeZone,
        SnapshotType snapshotType,
        SnapshotStatus snapshotStatus,
        Integer versionNo,
        String runId,
        Long buildMethodId,
        String description,
        List<Long> nodeQuoteIds,
        List<Long> pointIds
) { }

