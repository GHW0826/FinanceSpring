package com.finance.product.entity;

import com.finance.domain.product.BizDayConv;
import com.finance.domain.product.ModelSect;
import com.finance.domain.product.SettleSect;
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
@AllArgsConstructor // 우리가 직접 사용할 전체 생성자 (clientId, password, clientName)
public class ProductSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // SwapSide 등 구분 필드
   // private String swapSide; // 또는 enum으로 관리
    private LocalDate effectDate;   // 상품 시작일
    private LocalDate expiryDate;   // 상품 종료일

    @Enumerated(EnumType.STRING)
    private BizDayConv bizDayConv;  // 휴일처리기준

    @Enumerated(EnumType.STRING)
    private SettleSect settleSect;  // 결제구분

    @Enumerated(EnumType.STRING)
    private SettleSect settleBizDayConv;  // 결제휴일처리기준

    private int settleLags;


}
