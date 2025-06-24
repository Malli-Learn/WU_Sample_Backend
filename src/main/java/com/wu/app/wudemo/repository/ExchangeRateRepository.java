package com.wu.app.wudemo.repository;

import com.wu.app.wudemo.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findTopByBaseCurrencyAndTargetCurrencyOrderByFetchedAtDesc(String baseCurrency, String targetCurrency);
}
