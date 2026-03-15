package com.finance.common.reference.repository;

import com.finance.common.reference.entity.Country;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByCountryIso2(String countryIso2);

    Optional<Country> findByCountryIso3(String countryIso3);

    List<Country> findAllByActive(boolean active, Sort sort);
}