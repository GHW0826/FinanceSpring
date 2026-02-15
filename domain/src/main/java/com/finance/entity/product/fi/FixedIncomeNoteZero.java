package com.finance.entity.product.fi;

import com.finance.entity.product.ProductSchedule;
import com.finance.enums.ModelSect;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "fi_note_zero")
@DiscriminatorValue("FI-NOTE-ZERO") // 부모의 @DiscriminatorColumn 값
@Getter
@NoArgsConstructor
public class FixedIncomeNoteZero extends FixedIncome {

    @Override
    protected void MakeModelSect() {
        // 채권 전용 섹터 결정 로직
        modelSect = ModelSect.FI1;
    }

    @Override
    public List<ProductSchedule> MakeProductSchedule() {

        // 할인채는 만기 스케쥴만 있음
        ProductSchedule matur = new ProductSchedule() {

        };

        return List.of(matur);
    }
}
