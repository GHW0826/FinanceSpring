package com.finance.common.reference.repository;

import com.finance.common.reference.entity.Country;
import com.finance.common.reference.entity.CurrencyMaster;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyMasterRepository extends JpaRepository<CurrencyMaster, Long> {
}
