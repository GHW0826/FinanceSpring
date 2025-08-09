package com.finance.product.dto;

import com.finance.product.entity.Product;
import com.finance.product.entity.ProductSchedule;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SaveFiFwdRequest extends SaveProductRequest {
    protected double principal;
    protected double annualRate;
    protected int days;

    @Override
    public List<ProductSchedule> createSchedule(Product product) {
        List<ProductSchedule> schedules = new ArrayList<>();
        // 예: swap이면 leg별로 Schedule 생성
        schedules.add(new ProductSchedule(
                null,
                product,
                "1"
        ));
        return schedules;
    }
}