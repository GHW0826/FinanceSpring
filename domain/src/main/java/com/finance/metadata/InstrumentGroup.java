package com.finance.metadata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "instrument_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrumentGroup {
    @Id
    @Column(name="instrument_group_code", length = 20, nullable = false)
    private String code;

    @Column(name = "instrument_group_name", length = 100, nullable = false)
    private String name;
}
