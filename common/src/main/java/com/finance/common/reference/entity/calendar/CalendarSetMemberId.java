package com.finance.common.reference.entity.calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CalendarSetMemberId implements Serializable {

    @Column(name = "calendar_set_id", nullable = false)
    @Comment("캘린더 세트 식별자(FK)")
    private Long calendarSetId;

    @Column(name = "calendar_id", nullable = false)
    @Comment("멤버 캘린더 식별자(FK)")
    private Long calendarId;
}