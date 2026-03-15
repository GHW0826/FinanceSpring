package com.finance.common.common.repository;

import com.finance.common.common.entity.InstrumentCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstrumentCategoryRepository extends JpaRepository<InstrumentCategory, Long> {
}
