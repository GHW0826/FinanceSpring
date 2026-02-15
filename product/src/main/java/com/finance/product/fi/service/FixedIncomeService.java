package com.finance.product.fi.service;

import com.finance.entity.tools.Holiday;
import com.finance.entity.product.ProductSchedule;
import com.finance.product.core.repository.ProductScheduleRepository;
import com.finance.entity.product.fi.FixedIncome;
import com.finance.entity.product.fi.FixedIncomeNoteZero;
import com.finance.product.fi.repository.FixedIncomeRepository;
import com.finance.entity.product.Product;
import com.finance.product.core.dto.SaveProductRequest;
import com.finance.product.core.dto.SaveProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FixedIncomeService {
    private final FixedIncomeRepository fixedIncomeRepository;
    private final ProductScheduleRepository productScheduleRepository;

    public FixedIncomeService(
            FixedIncomeRepository fixedIncomeRepository,
            ProductScheduleRepository productScheduleRepository
    ) {
        this.fixedIncomeRepository = fixedIncomeRepository;
        this.productScheduleRepository = productScheduleRepository;
    }

    public SaveProductResponse Create(SaveProductRequest dto) {
        FixedIncome prod = new FixedIncomeNoteZero();
        Product saved = fixedIncomeRepository.save(prod);

        List<ProductSchedule> schedules = prod.MakeProductSchedule();
        productScheduleRepository.saveAll(schedules);

        List<Holiday> holidays = prod.MakeHoliday();

        return new SaveProductResponse(
                saved.getId(),
                saved.getName(),
                saved.getStatus(),
                saved.getAssetGrp(),
                saved.getInstGrp(),
                saved.getPayoffPattern()
        );
    }
}