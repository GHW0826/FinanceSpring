package com.finance.common.reference.entity.calendar;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.CalendarType;
import com.finance.common.reference.entity.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(
    name = "calendar",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_calendar_code", columnNames = "calendar_code")
    }
)
@Comment("영업일 판정을 위한 캘린더 마스터 (국가/은행/거래소/커스텀 단위)")
public class Calendar extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_id")
    @Comment("캘린더 식별자(PK)")
    private Long id;

    @Column(name = "calendar_code", length = 32, nullable = false)
    @Comment("캘린더 코드(유니크) 예: kr_bank, usny, euta(target)")
    private String calendarCode;

    @Column(name = "calendar_name", length = 200, nullable = false)
    @Comment("캘린더 표시명")
    private String calendarName;

    @Enumerated(EnumType.STRING)
    @Column(name = "calendar_type", length = 20, nullable = false)
    @Comment("캘린더 타입(COUNTRY_PUBLIC/BANK/EXCHANGE/REGION/CUSTOM)")
    private CalendarType calendarType;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "country_id")
    @Comment("소속 국가(FK). 국가 기반 캘린더면 설정")
    private Country country;

    @Column(name = "region_code", length = 32)
    @Comment("국가 내 지역코드(선택) 예: MY-JOHOR 등")
    private String regionCode;

    @Column(name = "timezone", length = 64, nullable = false)
    @Comment("IANA Time Zone (현지 날짜 판정용) 예: Asia/Seoul")
    private String timezone;

    @Column(name = "active", nullable = false)
    @Comment("사용 여부")
    private boolean active = true;

    protected Calendar() {}

    public void update(
            String calendarCode,
            String calendarName,
            CalendarType calendarType,
            Country country,
            String regionCode,
            String timezone,
            Boolean active
    ) {
        if (calendarCode != null) {
            this.calendarCode = calendarCode;
        }
        if (calendarName != null) {
            this.calendarName = calendarName;
        }
        if (calendarType != null) {
            this.calendarType = calendarType;
        }
        if (country != null) {
            this.country = country;
        }
        if (regionCode != null) {
            this.regionCode = regionCode;
        }
        if (timezone != null) {
            this.timezone = timezone;
        }
        if (active != null) {
            this.active = active;
        }
    }

    public void put(
            String calendarCode,
            String calendarName,
            CalendarType calendarType,
            Country country,
            String regionCode,
            String timezone,
            boolean active
    ) {
        this.calendarCode = calendarCode;
        this.calendarName = calendarName;
        this.calendarType = calendarType;
        this.country = country;
        this.regionCode = regionCode;
        this.timezone = timezone;
        this.active = active;
    }
}