package com.finance.common.reference.entity.calendar;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Immutable;

// No Make
// Make BatchJob or trigger
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(
    name = "calendar_day",
    indexes = {
        @Index(name = "ix_calendar_day_bdayseq", columnList = "calendar_id, business_day_sequence"),
        @Index(name = "ix_calendar_day_isbiz", columnList = "calendar_id, day_date, is_business_day")
    }
)
@Comment("캘린더 일자 파생 테이블(캐시). 주말/예외를 반영한 영업일 여부 및 영업일 시퀀스 저장")
@Immutable
@Check(constraints = "iso_weekday between 1 and 7")
public class CalendarDay {
    @EmbeddedId
    private CalendarDayId id;

    @MapsId("calendarId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "calendar_id", nullable = false)
    @Comment("캘린더(FK)")
    private Calendar calendar; // 필드명은 calendarId보다 calendar가 자연스러움

    @Column(name = "iso_weekday", nullable = false)
    @Comment("ISO 요일(1=Mon ... 7=Sun). day_date로부터 배치 생성 시 계산(또는 Generated Column)")
    private short isoWeekday;

    @Column(name = "is_weekend", nullable = false)
    @Comment("주말이면 true (calendar_weekend + weekend_profile 적용 결과)")
    private boolean weekend;

    @Column(name = "is_exception", nullable = false)
    @Comment("예외가 존재하면 true (calendar_exception 존재 여부)")
    private boolean exception;

    @Column(name = "is_business_day", nullable = false)
    @Comment("최종 영업일 여부 (weekend/exception 반영 결과)")
    private boolean businessDay;

    @Column(name = "business_day_sequence", nullable = false)
    @Comment("영업일 시퀀스(누적). 영업일 이동(T+n) 계산을 빠르게 하기 위한 값")
    private int businessDaySequence;

    protected CalendarDay() {}
}