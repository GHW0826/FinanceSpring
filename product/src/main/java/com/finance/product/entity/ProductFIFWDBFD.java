package com.finance.product.entity;

import com.finance.domain.product.Category.AssetGrp;
import com.finance.domain.product.Category.InstGrp;
import com.finance.domain.product.Category.PayoffPattern;
import com.finance.domain.product.ModelSect;
import com.finance.domain.product.Position;
import com.finance.domain.product.ProductSect;
import com.finance.domain.product.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productFIFWDBFD")
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor // 우리가 직접 사용할 전체 생성자 (clientId, password, clientName)
public class ProductFIFWDBFD extends Product {
    public String dum;

    public ProductFIFWDBFD(
            String name,
            Status status,
            AssetGrp assetGrp,
            InstGrp instGrp,
            PayoffPattern payoffPattern,
            ProductSect productSect,
            Position position,
            ModelSect modelSect,
            String dum
    ) {
        super(name, status, assetGrp, instGrp, payoffPattern, productSect, position, modelSect);
        this.dum = dum;
    }
}
