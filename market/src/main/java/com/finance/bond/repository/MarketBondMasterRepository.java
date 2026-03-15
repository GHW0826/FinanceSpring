package com.finance.bond.repository;

import com.finance.common.market.entity.bond.MarketBond;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketBondMasterRepository extends JpaRepository<MarketBond, String> {
    Optional<MarketBond> findByMarketCode(String marketCode);
    // 순수 delete 파생 메서드(리턴은 보통 삭제 건수)
    long deleteByMarketCode(String marketCode);
}
