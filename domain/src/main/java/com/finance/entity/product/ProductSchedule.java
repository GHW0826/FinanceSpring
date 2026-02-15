package com.finance.entity.product;

import com.finance.domain.product.BizDayConv;
import com.finance.domain.product.ScheduleSect;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


// 상품의 일정관련 데이터를 관리하는 테이블
@Entity
@Table(name = "ProductSchedule")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor
public class ProductSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private ScheduleSect scheduleSect;
    // SwapSide 등 구분 필드
   // private String swapSide; // 또는 enum으로 관리
    private LocalDate startDate;   // 상품 시작일
    private LocalDate endDate;   // 상품 종료일

    @Enumerated(EnumType.STRING)
    private BizDayConv bizDayConv;  // 휴일처리기준

    private int lags;
}
