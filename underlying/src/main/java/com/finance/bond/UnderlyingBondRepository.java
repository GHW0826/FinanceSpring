package com.finance.bond;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnderlyingBondRepository extends JpaRepository<UnderlyingBond, String> {
    Optional<UnderlyingBond> findByUnderlyingCd(String underCd);
}
