package com.finance.common.underlying.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "UnderlyingBondMaster")
@DiscriminatorValue("BOND")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnderlyingBondMaster extends UnderlyingMaster {
    @Column(name = "FACE_VALUE")
    private Double faceValue;
}
