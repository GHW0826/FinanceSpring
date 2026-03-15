package com.finance.common.market.entity.valuation;

import com.finance.common.enums.PriceType;
import com.finance.common.market.entity.bond.BondCurve;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "bond_valuation_context")
@DiscriminatorValue("BOND")
@PrimaryKeyJoinColumn(name = "id")
@Comment("채권 평가 컨텍스트")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BondValuationContext extends ValuationMarketContext {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_curve_id")
    @Comment("할인 커브(FK)")
    private BondCurve discountCurve;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spread_curve_id")
    @Comment("스프레드 커브(FK)")
    private BondCurve spreadCurve;

    @Enumerated(EnumType.STRING)
    @Column(name = "price_type", nullable = false, length = 10)
    @Comment("가격 타입(CLEAN/DIRTY)")
    private PriceType priceType;
}
