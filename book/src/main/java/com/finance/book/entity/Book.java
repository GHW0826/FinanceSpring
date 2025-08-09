package com.finance.book.entity;

import com.finance.domain.product.BookStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor // 우리가 직접 사용할 전체 생성자 (clientId, password, clientName)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private String CounterPartyCd;

    private String name;

    private String code;

    @Column(name = "product_id")
    private Long productId;
}
