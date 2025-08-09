package com.finance.product;

import com.finance.product.entity.ProductFixedIncome;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductFixedIncomeRepository extends JpaRepository<ProductFixedIncome, Long> {
}
