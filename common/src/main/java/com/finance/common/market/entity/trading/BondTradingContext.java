package com.finance.common.market.entity.trading;

import com.finance.common.enums.ListingSection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Entity
@Table(name = "bond_trading_context")
@DiscriminatorValue("BOND")
@PrimaryKeyJoinColumn(name = "id")
@Comment("채권 거래 컨텍스트")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BondTradingContext extends TradingMarketContext {

    @Enumerated(EnumType.STRING)
    @Column(name = "listing_section", nullable = false, length = 20)
    @Comment("상장 구분(LISTED/OTC)")
    private ListingSection listingSection;

    @Column(name = "tick_size", precision = 19, scale = 10)
    @Comment("호가 단위(예: 0.01)")
    private BigDecimal tickSize;

    @Column(name = "lot_size", precision = 19, scale = 2)
    @Comment("거래 단위(예: 1,000,000)")
    private BigDecimal lotSize;
}
