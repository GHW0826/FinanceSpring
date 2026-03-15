package com.finance.common.reference.entity.calendar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(
    name = "calendar_set_member",
    indexes = {
        @Index(name = "ix_calendar_set_member_seq", columnList = "calendar_set_id, seq_no")
    }
)
@Comment("조합 캘린더 구성원(세트에 포함된 캘린더 목록)")
public class CalendarSetMember {

    @EmbeddedId
    private CalendarSetMemberId id;

    @MapsId("calendarSetId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "calendar_set_id", nullable = false)
    @Comment("캘린더 세트(FK)")
    private CalendarSet calendarSet;

    @MapsId("calendarId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "calendar_id", nullable = false)
    @Comment("캘린더(FK)")
    private Calendar calendar;

    @Column(name = "seq_no", nullable = false)
    @Comment("구성 순서(표시/비교용)")
    private int seqNo;

    protected CalendarSetMember() {}

    public void update(Integer seqNo) {
        if (seqNo != null) {
            this.seqNo = seqNo;
        }
    }

    public void put(int seqNo) {
        this.seqNo = seqNo;
    }
}
