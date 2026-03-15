package com.finance.common.reference.entity.calendar;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class WeekendProfileDayId implements Serializable {

    @Column(name = "weekend_profile_id", nullable = false)
    @Comment("주말 프로필 식별자(FK)")
    private Long weekendProfileId;

    @Column(name = "iso_weekday", nullable = false)
    @Comment("ISO 요일(1=Mon ... 7=Sun)")
    private short isoWeekday;
}