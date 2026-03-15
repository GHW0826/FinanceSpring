package com.finance.common.reference.entity.calendar;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.CalendarJoinRule;
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
    name = "calendar_set",
    uniqueConstraints = {
            @UniqueConstraint(name = "uk_calendar_set_code", columnNames = "set_code")
    }
)
@Comment("조합 캘린더(다수 캘린더 결합). 크로스 통화/다지역 결제 등에 사용")
public class CalendarSet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_set_id")
    @Comment("캘린더 세트 식별자(PK)")
    private Long id;

    @Column(name = "set_code", length = 64, nullable = false)
    @Comment("세트 코드(유니크) 예: KR_BANK+USNY")
    private String setCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "join_rule", length = 16, nullable = false)
    @Comment("결합 규칙(JOIN_HOLIDAYS/JOIN_BUSINESS_DAYS)")
    private CalendarJoinRule joinRule;

    @Column(name = "description")
    @Comment("설명")
    private String description;

    protected CalendarSet() {}

    public void update(String setCode, CalendarJoinRule joinRule, String description) {
        if (setCode != null) {
            this.setCode = setCode;
        }
        if (joinRule != null) {
            this.joinRule = joinRule;
        }
        if (description != null) {
            this.description = description;
        }
    }

    public void put(String setCode, CalendarJoinRule joinRule, String description) {
        this.setCode = setCode;
        this.joinRule = joinRule;
        this.description = description;
    }
}