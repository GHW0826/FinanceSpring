package com.finance.common.reference.repository;

import com.finance.common.reference.entity.Country;
import com.finance.common.reference.entity.Vendor;
import com.finance.common.enums.VendorStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findAllByActive(boolean active, Sort sort);
}
