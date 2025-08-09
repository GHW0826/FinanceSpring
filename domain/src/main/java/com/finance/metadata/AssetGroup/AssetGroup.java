package com.finance.metadata.AssetGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "asset_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetGroup {
    @Id
    @Column(name="asset_group_code", length = 20, nullable = false)
    private String code;

    @Column(name = "asset_group_name", length = 100, nullable = false)
    private String name;
}
