package com.finance.common.reference.entity.calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CalendarExceptionId implements Serializable {

    @Column(name = "calendar_id", nullable = false)
    @Comment("캘린더 식별자(FK)")
    private Long calendarId;

    @Column(name = "exception_date", nullable = false)
    @Comment("예외 적용일(현지 날짜)")
    private LocalDate exceptionDate;
}