package com.finance.bond.repository;

import com.finance.common.market.entity.bond.BondCurveBuildMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BondCurveBuildMethodRepository extends JpaRepository<BondCurveBuildMethod, Long> {
}
