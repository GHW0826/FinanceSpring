package com.finance.common.export.entity;

import com.finance.common.transaction.entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "InterfaceBookInfo")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor
public class InterfaceBookInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK: InterfaceBookInfo.book_id → book.id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")   // DB 컬럼 이름
    private Book book;
}

