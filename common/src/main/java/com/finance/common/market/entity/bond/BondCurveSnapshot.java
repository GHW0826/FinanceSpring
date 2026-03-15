package com.finance.common.market.entity.bond;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.*;
import com.finance.common.market.entity.CurveBuildMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 채권 커브 스냅샷(마켓데이터 시계열의 "한 시점").
 * 의미:
 * - "어떤 커브(CurveId)"가
 * - "어떤 시장일자(ValuationDate)"에 대해
 * - "어떤 시각(AsOfTimestamp)" 기준으로
 * - "어떤 소스(SourceId)"에서 왔고
 * - "몇 번째 버전(Version)"인지
 * 를 식별하는 헤더.
 *
 * 이 Snapshot 1개에 대해:
 * - 입력(NodeQuote): PRICE/YIELD 노드들이 매달리고
 * - 산출(Point): YTM + ZERO + DF 포인트들이 매달린다.
 */
@Getter
@Setter
@Entity
@Table(
    name = "bond_curve_snapshot",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_bond_curve_snapshot_curve_val_date_asof_source_version",
            columnNames = {
                    "curve_id",
                    "valuation_date",
                    "as_of_timestamp",
                    "market_data_source_id",
                    "version_no"
            }
        )
    },
    indexes = {
        @Index(name = "ix_bond_curve_snapshot_curve_val_date", columnList = "curve_id, valuation_date"),
        @Index(name = "ix_bond_curve_snapshot_curve_status_type", columnList = "curve_id, snapshot_status, snapshot_type"),
        @Index(name = "ix_bond_curve_snapshot_as_of_timestamp", columnList = "as_of_timestamp")
    }
)
@Comment("채권 커브 스냅샷(시점별 마켓데이터 헤더)")
public class BondCurveSnapshot extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bond_curve_snapshot_id")
    @Comment("스냅샷 PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "curve_id",
        nullable = false
    )
    @Comment("어떤 BondCurve의 스냅샷인지")
    private BondCurve curve;

    @Column(name = "valuation_date", nullable = false)
    @Comment("시장 기준일자")
    private LocalDate valuationDate;

    @Column(name = "as_of_timestamp", nullable = false)
    @Comment("실제 관측/산출 시각")
    private Instant asOfTimestamp;

    @Column(name = "time_zone", length = 64)
    @Comment("타임존. 예: Asia/Seoul")
    private String timeZone;

    /* vendor인지 따로 엔티티 만들어야하는지 확인
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "market_data_source_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_bond_curve_snapshot_market_data_source")
    )
    @Comment("마켓데이터 소스 FK")
    private MarketDataSource marketDataSource;
    */

    @Enumerated(EnumType.STRING)
    @Column(name = "snapshot_type", length = 32, nullable = false)
    @Comment("스냅샷 종류")
    private SnapshotType snapshotType;

    @Enumerated(EnumType.STRING)
    @Column(name = "snapshot_status", length = 32, nullable = false)
    @Comment("스냅샷 상태")
    private SnapshotStatus snapshotStatus = SnapshotStatus.PRELIMINARY;

    @Column(name = "version_no", nullable = false)
    @Comment("동일 시점 재산출 버전")
    private Integer versionNo = 1;

    @Column(name = "run_id", length = 64)
    @Comment("배치/엔진 실행 식별자")
    private String runId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bond_curve_build_method_id")
    @Comment("커브 산출 방법론 FK")
    private BondCurveBuildMethod buildMethod;

    @Column(name = "description", length = 2000)
    @Comment("비고")
    private String description;

    @OneToMany(mappedBy = "snapshot", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("nodeSeq ASC")
    @Comment("입력 노드 호가 목록")
    private List<BondCurveNodeQuote> nodeQuotes = new ArrayList<>();

    @OneToMany(mappedBy = "snapshot", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("pillarDate ASC")
    @Comment("산출 포인트 목록")
    private List<BondCurvePoint> points = new ArrayList<>();

    protected BondCurveSnapshot() {}

    public void addNodeQuote(BondCurveNodeQuote nodeQuote) {
        nodeQuotes.add(nodeQuote);
        nodeQuote.setSnapshot(this);
    }

    public void addPoint(BondCurvePoint point) {
        points.add(point);
        point.setSnapshot(this);
    }

    public void markFinal() {
        this.snapshotStatus = SnapshotStatus.FINAL;
    }

    public void markRejected() {
        this.snapshotStatus = SnapshotStatus.REJECTED;
    }
}