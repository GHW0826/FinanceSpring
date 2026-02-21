package com.finance.bond.repository;

import com.finance.common.market.entity.MarketDataBondMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketDataBondMasterRepository extends JpaRepository<MarketDataBondMaster, String> {
    Optional<MarketDataBondMaster> findByMarketDataCode(String marketDataCode);
    // 순수 delete 파생 메서드(리턴은 보통 삭제 건수)
    long deleteByMarketDataCode(String marketDataCode);
}
