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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CalendarWeekendId implements Serializable {

    @Column(name = "calendar_id", nullable = false)
    @Comment("캘린더 식별자(FK)")
    private Long calendarId;

    @Column(name = "valid_from", nullable = false)
    @Comment("적용 시작일(포함)")
    private LocalDate validFrom;
}