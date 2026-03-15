package com.finance.common.reference.repository;

import com.finance.common.reference.entity.Issuer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssuerRepository extends JpaRepository<Issuer, Long> {
    List<Issuer> findAllByActive(boolean active, Sort sort);
}
