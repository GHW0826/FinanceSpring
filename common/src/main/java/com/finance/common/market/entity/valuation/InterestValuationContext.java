package com.finance.common.market.entity.valuation;

import com.finance.common.market.entity.YieldCurve;
import jakarta.persistence.*;

@Entity
@Table(name = "InterestValuationContext")
@DiscriminatorValue("BOND")
public class InterestValuationContext extends ValuationMarketContext {

    @ManyToOne
    private YieldCurve discountCurve;

    @ManyToOne
    private YieldCurve projectionCurve;
}