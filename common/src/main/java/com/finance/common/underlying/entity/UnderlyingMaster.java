package com.finance.common.underlying.entity;


import com.finance.common.enums.AssetGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UnderlyingMaster")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ASSET_TYPE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnderlyingMaster {

    // Code
    @Id
    @Column(name = "UnderlyingCode")
    private String underlyingCode;

    // Name
    @Column(name = "Name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "ASSET_GROUP", nullable = false)
    private AssetGroup assetGroup;

    // 비고
    @Column(name = "Description")
    private String description;
}
