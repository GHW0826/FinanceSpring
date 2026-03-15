package com.finance.common.market.entity.trading;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "InterestTradingContext")
@DiscriminatorValue("IR")
public class InterestTradingContext extends TradingMarketContext {

    private String clearingHouse;
}