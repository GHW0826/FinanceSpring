package com.finance.common.transaction.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BookType")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    // FK: book.product_id → product.id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")   // DB 컬럼 이름
    private Book book;

    private String name;
}
