package com.finance.bond.repository;

import com.finance.common.market.entity.bond.BondCurve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BondCurveMasterRepository extends JpaRepository<BondCurve, Long> {
}
