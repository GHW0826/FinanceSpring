package com.finance.product.service;

import com.finance.product.repository.ProductScheduleRepository;
import com.finance.product.fi.repository.FixedIncomeRepository;
import com.finance.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final FixedIncomeRepository fiRepository;
    private final ProductScheduleRepository productScheduleRepository;

    public ProductService(ProductRepository productRepository,
                          ProductScheduleRepository productScheduleRepository,
                          FixedIncomeRepository fiRepository) {
        this.productRepository = productRepository;
        this.productScheduleRepository = productScheduleRepository;
        this.fiRepository = fiRepository;
    }
}