package com.finance.common.reference.entity.calendar;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.CalendarExceptionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;


// 휴장일(HOLIDAY) 과 조기폐장(EARLY_CLOSE) 을 같이 보여준다.
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(
    name = "calendar_exception",
    indexes = {
        @Index(name = "ix_calendar_exception_date", columnList = "calendar_id, exception_date")
    }
)
@Comment("캘린더 예외(휴일/임시휴장/주말근무일 등). is_business_day로 열림/닫힘을 통일")
public class CalendarException extends BaseEntity {
    @EmbeddedId
    private CalendarExceptionId calendarExceptionId;

    @MapsId("calendarId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "calendar_id", nullable = false)
    @Comment("캘린더(FK)")
    private Calendar calendar;

    @Column(name = "is_business_day", nullable = false)
    @Comment("해당 날짜가 영업일이면 true. 공휴일/휴장은 false, 주말근무일은 true")
    private boolean businessDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "exception_type", length = 20, nullable = false)
    @Comment("예외 타입(HOLIDAY/SPECIAL_CLOSURE/WORKING_DAY/...)")
    private CalendarExceptionType exceptionType;

    @Column(name = "exception_name", length = 200)
    @Comment("예외명/휴일명")
    private String exceptionName;

    @Column(name = "observed_of")
    @Comment("대체공휴일/관측휴일의 원본 날짜(선택)")
    private LocalDate observedOf;

    @Column(name = "source")
    @Comment("데이터 출처/버전/근거(선택)")
    private String source;

    protected CalendarException() {}

    public void update(
            Boolean businessDay,
            CalendarExceptionType exceptionType,
            String exceptionName,
            LocalDate observedOf,
            String source
    ) {
        if (businessDay != null) {
            this.businessDay = businessDay;
        }
        if (exceptionType != null) {
            this.exceptionType = exceptionType;
        }
        if (exceptionName != null) {
            this.exceptionName = exceptionName;
        }
        if (observedOf != null) {
            this.observedOf = observedOf;
        }
        if (source != null) {
            this.source = source;
        }
    }

    public void put(
            boolean businessDay,
            CalendarExceptionType exceptionType,
            String exceptionName,
            LocalDate observedOf,
            String source
    ) {
        this.businessDay = businessDay;
        this.exceptionType = exceptionType;
        this.exceptionName = exceptionName;
        this.observedOf = observedOf;
        this.source = source;
    }
}