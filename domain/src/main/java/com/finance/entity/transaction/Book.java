package com.finance.entity.transaction;

import com.finance.domain.product.BookStatus;
import com.finance.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK: book.product_id → product.id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")   // DB 컬럼 이름
    private Product product;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private String CounterPartyCd;

    private String name;

    private String code;


}
