package com.finance.fixedincome;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MdBondMasterRepository extends JpaRepository<MdBondMaster, String> {
    Optional<MdBondMaster> findByMdCd(String mdCd);
}
