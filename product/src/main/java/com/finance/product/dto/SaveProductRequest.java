package com.finance.product.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.finance.domain.product.Category.AssetGrp;
import com.finance.domain.product.Category.InstGrp;
import com.finance.domain.product.Category.PayoffPattern;
import com.finance.domain.product.ModelSect;
import com.finance.domain.product.Position;
import com.finance.domain.product.ProductSect;
import com.finance.domain.product.Status;
import com.finance.product.entity.Product;
import com.finance.product.entity.ProductSchedule;
import com.finance.product.fi.FIType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
// 부모 추상 클래스: 타입 정보 포함
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,          // 타입 구분: 이름 사용
        include = JsonTypeInfo.As.PROPERTY,  // json에 property 추가
        property = "fiType",                    // "type": "fixedIncome" 등으로 구분
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SaveFiFwdBfdRequest.class, name = "FIFWDBFD"),
        @JsonSubTypes.Type(value = SaveFiNtsZerRequest.class, name = "FIFWDBFD")
})
public abstract class SaveProductRequest {
    @NotNull
    private FIType fiType;

    protected String type;
    protected String name;
    protected String productName;
    protected Status status;
    protected AssetGrp assetGrp;
    protected InstGrp instGrp;
    protected PayoffPattern payoffPattern;
    protected ProductSect productSect;
    protected Position position;
    protected ModelSect modelSect;

    protected String dum;

    public abstract List<ProductSchedule> createSchedule(Product product);
}
