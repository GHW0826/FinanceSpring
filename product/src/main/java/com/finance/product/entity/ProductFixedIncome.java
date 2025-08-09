package com.finance.product.entity;

import com.finance.domain.product.AssetGrp;
import com.finance.domain.product.InstGrp;
import com.finance.domain.product.PayoffPattern;
import com.finance.domain.product.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productFixedIncome")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor // 우리가 직접 사용할 전체 생성자 (clientId, password, clientName)
public class ProductFixedIncome extends Product {
    public String dum;

    public ProductFixedIncome(
            Long instrumentId,
            String name,
            Status status,
            AssetGrp assetGrp,
            InstGrp instGrp,
            PayoffPattern payoffPattern,
            String dum
    ) {
        super(instrumentId, name, status, assetGrp, instGrp, payoffPattern, null); // 부모 생성자 호출 (상속 구조라면)
        this.dum = dum;
    }
}
