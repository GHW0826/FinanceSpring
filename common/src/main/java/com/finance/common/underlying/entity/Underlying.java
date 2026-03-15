package com.finance.common.underlying.entity;


import com.finance.common.enums.AssetGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UnderlyingMaster")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "AssetGroup")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Underlying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // AssetGroup : Bond, Ir, Fx, Credit, Hybrid
//    @Enumerated(EnumType.STRING)
//    @Column(name = "AssetGroup", nullable = false)
//    private AssetGroup assetGroup;

    @Column(name = "AssetCode", nullable = false)
    private String assetCode;

    // Name
    @Column(name = "Name")
    private String name;

    // 비고
    @Column(name = "Description")
    private String description;
}
