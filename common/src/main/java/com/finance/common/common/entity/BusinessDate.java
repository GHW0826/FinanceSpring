package com.finance.common.common.entity;


import com.finance.common.enums.domain.product.BusinessSect;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "BusinessDate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDate {
    @Id
    @Column(name = "BIZ_DATE", nullable = false)
    private Date businessDate;
    private Date prevBusinessDate;
    private Date nextBusinessDate;
    private BusinessSect businessSect;
    private Date accCloseDate;      // 회계마감일
}
