package com.finance.curve.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rateCurve")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor // 우리가 직접 사용할 전체 생성자 (clientId, password, clientName)
public class RateCurve {
    @Id
    @Column(name = "CRVID", nullable = false)
    private Long crvId;

    @Column(name = "REVID", nullable = false)
    private Long revId;

    @Column(name = "STATUS", length = 1)
    private String status;

    @Column(name = "APPDATE", nullable = false, length = 8)
    private String appDate;

    @Column(name = "NAME", length = 500)
    private String name;

    @Column(name = "SMDCD", length = 20)
    private String smdCd;

    @Column(name = "CCY", length = 3)
    private String ccy;

    @Column(name = "CCY2", length = 3)
    private String ccy2;

    @Column(name = "BASEDATASECT", length = 3)
    private String baseDataSect;

    @Column(name = "BASEDATATYPE", length = 2)
    private String baseDataType;

    @Column(name = "ASSETGRP", length = 2)
    private String assetGrp;

    @Column(name = "RATEGRP", length = 2)
    private String rateGrp;

    @Column(name = "CALENDARCD", length = 20)
    private String calendarCd;

    @Column(name = "MATUR", length = 1024)
    private String matur;

    @Column(name = "RATEKIND", length = 2)
    private String rateKind;

    @Column(name = "DAYCNTCONV", length = 4)
    private String dayCntConv;

    @Column(name = "BIZDAYADJUSTYN", length = 1)
    private String bizDayAdjustYn;

    @Column(name = "RATETYPE", length = 1)
    private String rateType;

    @Column(name = "CMPNDFREQ", length = 1)
    private String cmpndFreq;

    @Column(name = "DESCRIPTION", length = 50)
    private String description;

    @Column(name = "OWNER", length = 20)
    private String owner;

    @Column(name = "TIMESTAMP", length = 15)
    private String timestamp;

    @Column(name = "WHO", length = 20)
    private String who;

    @Column(name = "SPREADSIDE", length = 1)
    private String spreadSide;

    @Column(name = "PAYFREQ", length = 1)
    private String payFreq;

    @Column(name = "UNDERCD", length = 30)
    private String underCd;

    @Column(name = "DAYCNTCONV2", length = 4)
    private String dayCntConv2;

    @Column(name = "BIZDAYADJUSTYN2", length = 1)
    private String bizDayAdjustYn2;

    @Column(name = "CALENDARCD2", length = 20)
    private String calendarCd2;

    @Column(name = "CMPNDFREQ2", length = 1)
    private String cmpndFreq2;

    @Column(name = "PAYFREQ2", length = 1)
    private String payFreq2;

    @Column(name = "UNDERCD2", length = 30)
    private String underCd2;

    @Column(name = "SYNCRVID", length = 1024)
    private String syncRvId;

    @Column(name = "RATEMATUR", length = 10)
    private String rateMatur;

    @Column(name = "RATEMATUR2", length = 10)
    private String rateMatur2;

    @Column(name = "DELAYTERM")
    private Integer delayTerm;

    @Column(name = "SHORTMATUR", length = 512)
    private String shortMatur;

    @Column(name = "SHORTSYNCRVID", length = 128)
    private String shortSyncRvId;

    @Column(name = "SHORTFXPOINT", length = 128)
    private String shortFxPoint;

    @Column(name = "ORIGINMKTCD", length = 20)
    private String originMktCd;

    @Column(name = "ORIGINSRCCD", length = 4)
    private String originSrcCd;

    @Column(name = "BIZDAYCONV", length = 1)
    private String bizDayConv;

    @Column(name = "DATEROLL", length = 3)
    private String dateRoll;

    @Column(name = "RESETFREQ", length = 1)
    private String resetFreq;

    @Column(name = "FIXCALENDARCD", length = 20)
    private String fixCalendarCd;

    @Column(name = "BIZDAYCONV2", length = 1)
    private String bizDayConv2;

    @Column(name = "DATEROLL2", length = 3)
    private String dateRoll2;

    @Column(name = "RESETFREQ2", length = 1)
    private String resetFreq2;

    @Column(name = "FIXCALENDARCD2", length = 20)
    private String fixCalendarCd2;

    @Column(name = "RFRSECT", length = 1)
    private String rfrSect;

    @Column(name = "SUBCRVNAME", length = 30)
    private String subCrvName;

    @Column(name = "PRICEKIND", length = 2)
    private String priceKind;

    @Column(name = "LONGMATUR", length = 512)
    private String longMatur;

    @Column(name = "BOUNDTERM", length = 10)
    private String boundTerm;
}
