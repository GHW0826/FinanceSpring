package com.finance.metadata.InstrumentCategory;


import com.finance.metadata.InstrumentCategoryId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instrument_category")
@IdClass(InstrumentCategoryId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrumentCategory {

    @Id
    @Column(name = "instrument_group_code", length = 30, nullable = false)
    private String instrumentGroupCode;

    @Id
    @Column(name = "asset_group_code", length = 30, nullable = false)
    private String assetGroupCode;

    @Id
    @Column(name = "payoff_pattern_code", length = 30, nullable = false)
    private String payoffPatternCode;

    @Column(name = "name", length = 50, nullable = false)
    private String name;
}