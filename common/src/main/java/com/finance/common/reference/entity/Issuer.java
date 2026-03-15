package com.finance.common.reference.entity;

import com.finance.common.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "issuer")
@Comment("발행체 마스터(실제 발행체 및 발행체 그룹을 함께 관리)")
public class Issuer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issuer_id")
    @Comment("발행체 PK")
    private Long id;

    @Column(name = "issuer_code", length = 64, nullable = false)
    @Comment("발행체 코드(업무키, 유니크). 예: GOVT, AGENCY, CORP, ROK, KDB, SAMSUNG_ELEC")
    private String issuerCode;

    @Column(name = "name", length = 256, nullable = false)
    @Comment("발행체명 또는 발행체 그룹명")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "country_id")
    @Comment("국가 마스터 FK. 그룹 issuer는 null 가능")
    private Country country;

    @Column(name = "lei", length = 20)
    @Comment("LEI(Legal Entity Identifier). 실제 법적 발행체 식별 시 사용")
    private String lei;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_issuer_id")
    @Comment("상위 발행체 또는 발행체 그룹. 예: ROK -> GOVT, CORP_FIN_AA -> CORP_FIN")
    private Issuer parentIssuer;

    @Column(name = "group_flag", nullable = false)
    @Comment("그룹 issuer 여부. true면 GOVT, CORP_AA 같은 논리 그룹")
    private boolean groupFlag = false;

    @Column(name = "active", nullable = false)
    @Comment("사용 여부")
    private boolean active = true;

    @Column(name = "description", length = 2000)
    @Comment("비고/운영 메모")
    private String description;

    protected Issuer() {}

    public void update(
            String issuerCode,
            String name,
            Country country,
            String lei,
            Issuer parentIssuer,
            Boolean groupFlag,
            boolean active,
            String description
    ) {
        this.issuerCode = issuerCode;
        this.name = name;
        this.country = country;
        this.lei = lei;
        this.parentIssuer = parentIssuer;
        if (groupFlag != null) {
            this.groupFlag = groupFlag;
        }
        this.active = active;
        this.description = description;
    }
}

