package com.finance.bollingerband;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BollingerBandRepository extends JpaRepository<BollingerBand, Long> {
    List<BollingerBand> findBySymbol(String symbol);
}