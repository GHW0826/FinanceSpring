package com.finance.common.transaction.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//
@Entity
@Table(name = "Workflow")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
