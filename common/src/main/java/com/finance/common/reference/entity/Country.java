package com.finance.common.reference.entity;

import com.finance.common.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(
    name = "country",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_country_iso2", columnNames = "country_iso2"),
        @UniqueConstraint(name = "uk_country_iso3", columnNames = "country_iso3")
    },
    indexes = {
        @Index(name = "ix_country_iso2", columnList = "country_iso2"),
        @Index(name = "ix_country_iso3", columnList = "country_iso3")
    }
)
@Comment("국가 마스터(ISO 3166-1 기반)")
public class Country extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country_iso2", length = 2, nullable = false)
    @Comment("ISO 3166-1 alpha-2 예: KR, US")
    private String countryIso2;

    @Column(name = "country_iso3", length = 3)
    @Comment("ISO 3166-1 alpha-3 예: KOR, USA")
    private String countryIso3;

    @Column(name = "numeric_code", length = 3)
    @Comment("ISO 3166-1 numeric code 예: 410, 840")
    private String numericCode;

    @Column(name = "name", nullable = false)
    @Comment("표시명(기본 언어) 예: Korea, United States")
    private String name;

    @Column(name = "timezone", length = 64)
    @Comment("대표 IANA Time Zone(선택) 예: Asia/Seoul")
    private String timezone;

    @Column(name = "active", nullable = false)
    @Comment("사용 여부")
    private boolean active = true;

    @Column(name = "description")
    @Comment("비고")
    private String description;

    protected Country() {}

    public void update(
            String countryIso2,
            String countryIso3,
            String numericCode,
            String name,
            String timezone,
            boolean active,
            String description
    ) {
        this.countryIso2 = countryIso2;
        this.countryIso3 = countryIso3;
        this.numericCode = numericCode;
        this.name = name;
        this.timezone = timezone;
        this.active = active;
        this.description = description;
    }
}