package com.finance.common.market.entity.bond;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.BondCurveSourceType;
import com.finance.common.enums.CurvePurpose;
import com.finance.common.enums.CurveRateRepresentation;
import com.finance.common.enums.CurveType;
import com.finance.common.reference.entity.CurrencyMaster;
import com.finance.common.reference.entity.Issuer;
import com.finance.common.reference.entity.Vendor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(
        name = "bond_curve_source",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_bond_curve_source_vendor_curve",
                        columnNames = {"vendor_id", "vendor_curve_code"}
                ),
                @UniqueConstraint(
                        name = "uk_bond_curve_source_curve_vendor_type",
                        columnNames = {"bond_curve_id", "vendor_id", "source_type"}
                )
        },
        indexes = {
                @Index(name = "ix_bond_curve_source_curve", columnList = "bond_curve_id"),
                @Index(name = "ix_bond_curve_source_vendor", columnList = "vendor_id"),
                @Index(name = "ix_bond_curve_source_type", columnList = "source_type")
        }
)
@Comment("내부 BondCurve와 외부 Vendor curve를 연결하는 소스 마스터")
public class BondCurveSource extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bond_curve_source_id")
    @Comment("채권 커브 소스 PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "bond_curve_id",
            nullable = false
    )
    @Comment("내부 bond curve FK")
    private BondCurve bondCurve;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "vendor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_bond_curve_source_vendor")
    )
    @Comment("외부 vendor FK")
    private Vendor vendor;

    @Enumerated(EnumType.STRING)
    @Column(name = "source_type", length = 32, nullable = false)
    @Comment("소스 유형")
    private BondCurveSourceType sourceType;

    @Column(name = "vendor_curve_code", length = 128, nullable = false)
    @Comment("벤더 시스템의 curve code")
    private String vendorCurveCode;

    @Column(name = "vendor_curve_name", length = 256)
    @Comment("벤더 시스템의 curve name")
    private String vendorCurveName;

    @Column(name = "priority", nullable = false)
    @Comment("우선순위. 숫자가 작을수록 우선")
    private Integer priority = 100;

    @Column(name = "active", nullable = false)
    @Comment("사용 여부")
    private boolean active = true;

    @Column(name = "description", length = 2000)
    @Comment("비고")
    private String description;

    protected BondCurveSource() {}
}