package com.finance.common.product.entity;

import com.finance.common.enums.domain.product.Position;
import com.finance.common.enums.domain.product.ProductSect;
import com.finance.common.enums.domain.product.SettleSect;
import com.finance.common.enums.domain.product.Status;
import com.finance.common.enums.AssetGroup;
import com.finance.common.enums.domain.product.Category.InstGrp;
import com.finance.common.enums.domain.product.Category.PayoffPattern;
import com.finance.common.common.entity.Holiday;
import com.finance.common.enums.ModelSect;
import com.finance.common.market.entity.trading.TradingMarketContext;
import com.finance.common.market.entity.valuation.ValuationMarketContext;
import com.finance.common.underlying.entity.Underlying;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
// 이 클래스랑 이걸 상속하는 애들(자식 엔티티들)을 DB에 어떻게 저장할 거냐 알려줌.
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING, length = 40)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private AssetGroup assetGrp;

    @Enumerated(EnumType.STRING)
    private InstGrp instGrp;

    @Enumerated(EnumType.STRING)
    private PayoffPattern payoffPattern;

    @Enumerated(EnumType.STRING)
    private ProductSect productSect;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private SettleSect settleSect;  // 결제구분

    @Enumerated(EnumType.STRING)
    protected ModelSect modelSect;

    // Product 1 : N Holiday
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Holiday> holidays = new ArrayList<>();
    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
        holiday.setProduct(this);
    }
    public void removeHoliday(Holiday holiday) {
        holidays.remove(holiday);
        holiday.setProduct(null);
    }

    public List<Holiday> MakeHoliday() {
        return null;
    };

    protected abstract void MakeModelSect();
    public abstract List<ProductSchedule> MakeProductSchedule();


    // 계약 구성요소
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNDERLYING_ID")
    private Underlying underlying;

    // 거래 시장
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRADING_CONTEXT_ID")
    private TradingMarketContext tradingContext;

    // 평가 환경
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VALUATION_CONTEXT_ID")
    private ValuationMarketContext valuationContext;

}
