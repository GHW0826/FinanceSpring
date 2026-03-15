package com.finance.common.reference.entity.calendar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;


@Getter @Setter
@AllArgsConstructor
@Entity
@Table(
    name = "CalendarWeekend",
    indexes = {
        @Index(name = "ix_calendar_weekend_range", columnList = "calendar_id, valid_from, valid_to")
    }
)
@Comment("캘린더별 주말 규칙(weekend profile) + 유효기간")
@Check(constraints = "valid_to is null or valid_to > valid_from")
public class CalendarWeekend {

    @EmbeddedId
    private CalendarWeekendId id;

    @MapsId("calendarId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "calendar_id", nullable = false)
    @Comment("캘린더(FK)")
    private Calendar calendar;

    @Column(name = "valid_to")
    @Comment("적용 종료일(제외). null이면 무기한")
    private LocalDate validTo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "weekend_profile_id", nullable = false)
    @Comment("주말 프로필(FK)")
    private WeekendProfile weekendProfile;

    protected CalendarWeekend() {}

    public void update(LocalDate validTo, WeekendProfile weekendProfile) {
        if (validTo != null) {
            this.validTo = validTo;
        }
        if (weekendProfile != null) {
            this.weekendProfile = weekendProfile;
        }
    }

    public void put(LocalDate validTo, WeekendProfile weekendProfile) {
        this.validTo = validTo;
        this.weekendProfile = weekendProfile;
    }
}
