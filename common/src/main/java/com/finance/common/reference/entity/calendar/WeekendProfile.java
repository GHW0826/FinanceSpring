package com.finance.common.reference.entity.calendar;

import com.finance.common.common.entity.BaseEntity;
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
    name = "weekend_profile",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_weekend_profile_code", columnNames = "profile_code")
    }
)
@Comment("주말 요일 패턴(재사용 가능) 예: SAT_SUN, FRI_SAT")
public class WeekendProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weekend_profile_id")
    @Comment("주말 프로필 식별자(PK)")
    private Long id;

    @Column(name = "profile_code", length = 32, nullable = false)
    @Comment("프로필 코드(유니크) 예: SAT_SUN, FRI_SAT")
    private String profileCode;

    @Column(name = "description")
    @Comment("설명")
    private String description;

    protected WeekendProfile() {}

    public void update(String profileCode, String description) {
        if (profileCode != null) {
            this.profileCode = profileCode;
        }
        if (description != null) {
            this.description = description;
        }
    }

    public void put(String profileCode, String description) {
        this.profileCode = profileCode;
        this.description = description;
    }
}
