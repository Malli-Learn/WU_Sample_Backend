package com.wu.app.wudemo.service;

import com.wu.app.wudemo.ExchangeRateClient;
import com.wu.app.wudemo.entity.ExchangeRate;
import com.wu.app.wudemo.repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ExchangeRateService {

    private final ExchangeRateClient client;
    private final ExchangeRateRepository repository;

    public ExchangeRateService(ExchangeRateClient client, ExchangeRateRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public BigDecimal getExchangeRate(String base, String target) {
        Optional<ExchangeRate> rate = repository.findTopByBaseCurrencyAndTargetCurrencyOrderByFetchedAtDesc(base, target);
        return rate.map(ExchangeRate::getRate)
                .orElseThrow(() -> new RuntimeException("Exchange rate not available for " + base + " to " + target));
    }

    public void fetchAndStore(String base, String target) {
        BigDecimal rate = client.getRate(base, target);
        ExchangeRate entity = new ExchangeRate();
        entity.setBaseCurrency(base);
        entity.setTargetCurrency(target);
        entity.setRate(rate);
        entity.setFetchedAt(LocalDateTime.now());
        repository.save(entity);
    }
}

