package com.finance.product;

import com.finance.product.entity.ProductSchedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductScheduleRepository extends JpaRepository<ProductSchedule, Long> {
}
