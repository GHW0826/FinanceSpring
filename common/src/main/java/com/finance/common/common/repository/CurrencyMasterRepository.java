package com.finance.common.common.repository;

import com.finance.common.common.entity.currency.CurrencyMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyMasterRepository extends JpaRepository<CurrencyMaster, String> {
}
