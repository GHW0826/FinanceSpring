package com.finance.metadata;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InstrumentCategoryId implements Serializable {

    private String instrumentGroupCode;
    private String assetGroupCode;
    private String payoffPatternCode;
}