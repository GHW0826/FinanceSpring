package com.finance.metadata;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instrument_category_back")
@IdClass(InstrumentCategoryId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrumentCategoryBack {

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

    @Column(name = "payoff_graph_enabled", length = 30, nullable = false)
    private String payoffGraphEnabled;

    @Column(name = "open_service_number", nullable = false)
    private Long openServiceNumber;

    @Column(name = "save_service_number", nullable = false)
    private Long saveServiceNumber;

    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @Column(name = "simm_calculation_section", length = 30, nullable = false)
    private String simmCalculationSection;

    @Column(name = "frtb_calculation_section", length = 30, nullable = false)
    private String frtbCalculationSection;

    @Column(name = "structured_enabled", length = 30, nullable = false)
    private String structuredEnabled;
}