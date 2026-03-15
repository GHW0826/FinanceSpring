package com.finance.common.reference.entity.calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CalendarDayId implements Serializable {
    @Column(name = "calendar_id", nullable = false)
    @Comment("캘린더 식별자(FK)")
    private Long calendarId;

    @Column(name = "day_date", nullable = false)
    @Comment("날짜(현지 DATE)")
    private LocalDate dayDate;
}