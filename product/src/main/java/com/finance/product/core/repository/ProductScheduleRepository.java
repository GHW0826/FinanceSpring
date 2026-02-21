package com.finance.product.core.repository;

import com.finance.common.product.entity.ProductSchedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductScheduleRepository extends JpaRepository<ProductSchedule, Long> {
}
