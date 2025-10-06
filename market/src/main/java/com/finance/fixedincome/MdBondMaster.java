package com.finance.fixedincome;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "md_bond_master")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor // 우리가 직접 사용할 전체 생성자 (clientId, password, clientName)
public class MdBondMaster {

    @Id
    private String mdCd;

    private String name;

    private String ccy;

    private String ccy2;

    private String time;

    private String assetGroup;

    private String mktdataGroup;

    private String mktdataSect;

    private Date lastMktDate;

    private String freq;

    private String srcCd;

    private int impDiff;

    private String impTime;

    private String fileId;
}