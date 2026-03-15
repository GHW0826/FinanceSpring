package com.finance.common.common.repository;

import com.finance.common.common.entity.InstrumentGroup;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstrumentGroupRepository extends JpaRepository<InstrumentGroup, Long> {
}
