package com.finance.common.reference.entity.calendar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "weekend_profile_day")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Check(constraints = "iso_weekday between 1 and 7")
@Comment("주말 프로필 상세(프로필별 요일의 주말 여부)")
public class WeekendProfileDay {

    @EmbeddedId
    private WeekendProfileDayId id;

    @MapsId("weekendProfileId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "weekend_profile_id", nullable = false)
    @Comment("주말 프로필(FK)")
    private WeekendProfile weekendProfile;

    @Column(name = "is_weekend", nullable = false)
    @Comment("해당 요일이 주말이면 true")
    private boolean weekend;

    public void update(Boolean weekend) {
        if (weekend != null) {
            this.weekend = weekend;
        }
    }

    public void put(boolean weekend) {
        this.weekend = weekend;
    }
}
