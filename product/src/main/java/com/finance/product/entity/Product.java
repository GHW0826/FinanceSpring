package com.finance.product.entity;

import com.finance.domain.product.*;
import com.finance.domain.product.Category.AssetGrp;
import com.finance.domain.product.Category.InstGrp;
import com.finance.domain.product.Category.PayoffPattern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor  // JPA가 반드시 필요로 함
@AllArgsConstructor // 우리가 직접 사용할 전체 생성자 (clientId, password, clientName)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrumentId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private AssetGrp assetGrp;

    @Enumerated(EnumType.STRING)
    private InstGrp instGrp;

    @Enumerated(EnumType.STRING)
    private PayoffPattern payoffPattern;

    @Enumerated(EnumType.STRING)
    private ProductSect productSect;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private ModelSect modelSect;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSchedule> schedules = new ArrayList<>();
    /*
    // 명목통화
    private String notionCcy;

    // 명목금액
    private Long notionAmount;

    @Enumerated(EnumType.STRING)
    private CancelType cancelType;
    */

    protected Product(String name, Status status, AssetGrp assetGrp,
                      InstGrp instGrp, PayoffPattern payoffPattern,
                      ProductSect productSect, Position position, ModelSect modelSect) {
        this.name = name;
        this.status = status;
        this.assetGrp = assetGrp;
        this.instGrp = instGrp;
        this.payoffPattern = payoffPattern;
        this.productSect = productSect;
        this.position = position;
        this.modelSect = modelSect;
    }
}
