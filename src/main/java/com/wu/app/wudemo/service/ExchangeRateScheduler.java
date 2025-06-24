package com.wu.app.wudemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateScheduler {

    private final ExchangeRateService service;

    public ExchangeRateScheduler(ExchangeRateService service) {
        this.service = service;
    }

    // Refresh every 6 hours
    @Scheduled(fixedRate = 6 * 60 * 60 * 1000)
    public void updateRates() {
        service.fetchAndStore("USD", "INR");
        service.fetchAndStore("EUR", "INR");
        service.fetchAndStore("GBP", "INR");
        // Add more if needed
    }
}

