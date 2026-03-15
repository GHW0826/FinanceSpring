package com.finance.bond.repository;

import com.finance.common.market.entity.Curve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurveMasterRepository extends JpaRepository<Curve, Long> {
    // 공통 검색 예시
    Optional<Curve> findById(Long id);
}
