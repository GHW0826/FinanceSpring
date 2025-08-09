package com.finance.product.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.finance.domain.product.AssetGrp;
import com.finance.domain.product.InstGrp;
import com.finance.domain.product.PayoffPattern;
import com.finance.domain.product.Status;
import com.finance.product.entity.Product;
import com.finance.product.entity.ProductSchedule;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
// 부모 추상 클래스: 타입 정보 포함
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,          // 타입 구분: 이름 사용
        include = JsonTypeInfo.As.PROPERTY,  // json에 property 추가
        property = "type"                    // "type": "fixedIncome" 등으로 구분
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SaveFiFwdBfdRequest.class, name = "fiFwdBfd")
})
public abstract class SaveProductRequest {
    protected String name;
    protected Status status;
    protected AssetGrp assetGrp;
    protected InstGrp instGrp;
    protected PayoffPattern payoffPattern;
    protected String dum;

    public abstract List<ProductSchedule> createSchedule(Product product);
}
