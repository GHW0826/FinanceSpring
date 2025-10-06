package com.finance.product;

import com.finance.product.entity.ProductFIFWDBFD;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductFixedIncomeRepository extends JpaRepository<ProductFIFWDBFD, Long> {
}
