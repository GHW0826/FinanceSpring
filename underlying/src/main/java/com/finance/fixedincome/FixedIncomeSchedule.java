package com.finance.fixedincome;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fixed_income_schedule")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
public class FixedIncomeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
