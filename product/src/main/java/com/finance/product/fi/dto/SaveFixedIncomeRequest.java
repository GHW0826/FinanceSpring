package com.finance.product.fi.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.finance.product.core.dto.SaveProductRequest;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
// 부모 추상 클래스: 타입 정보 포함
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "payoffPattern",
//        visible = true
//)
//@JsonSubTypes({
//        @JsonSubTypes.Type(
//                value = SaveFixedIncomeNoteZeroRequest.class,
//                name = "FIFWDBFD"
//        ),
//})
public class SaveFixedIncomeRequest extends SaveProductRequest {
    // protected double principal;
    // protected double annualRate;
    // protected int days;
}