package com.finance.entity.tools;


import com.finance.domain.product.BusinessSect;
import jakarta.persistence.Entity;
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

    private Date businessDate;
    private Date prevBusinessDate;
    private Date nextBusinessDate;
    private BusinessSect businessSect;
    private Date accCloseDate;      // 회계마감일
}
