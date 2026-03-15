package com.finance.common.reference.entity;

import com.finance.common.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(
    name = "vendor",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_vendor_code", columnNames = "vendor_code")
    },
    indexes = {
        @Index(name = "ix_vendor_code", columnList = "vendor_code"),
        @Index(name = "ix_vendor_name", columnList = "name")
    }
)
@Comment("데이터 공급자 마스터")
public class Vendor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    @Comment("벤더 PK")
    private Long id;

    @Column(name = "vendor_code", length = 64, nullable = false)
    @Comment("벤더 코드(업무키, 유니크). 예: KIS, BLOOMBERG, LSEG")
    private String vendorCode;

    @Column(name = "name", length = 128, nullable = false)
    @Comment("벤더명")
    private String name;

    @Column(name = "homepage_url", length = 512)
    @Comment("벤더 홈페이지 URL")
    private String homepageUrl;

    @Column(name = "active", nullable = false)
    @Comment("사용 여부")
    private boolean active = true;

    @Column(name = "description", length = 2000)
    @Comment("비고")
    private String description;

    protected Vendor() {}

    public void update(
            String vendorCode,
            String name,
            String homepageUrl,
            Boolean active,
            String description
    ) {
        this.vendorCode = vendorCode;
        this.name = name;
        this.homepageUrl = homepageUrl;
        this.active = active;
        this.description = description;
    }
}