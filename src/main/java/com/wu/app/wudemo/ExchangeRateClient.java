package com.wu.app.wudemo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

@Component
public class ExchangeRateClient {
    private final WebClient webClient;

    @Value("${exchange.api.key}")
    private String apiKey;

    public ExchangeRateClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://v6.exchangerate-api.com/v6").build();
    }

    public BigDecimal getRate(String base, String target) {
        String path = String.format("/%s/latest/%s", apiKey, base);

        JsonNode json = webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        if (!"success".equals(json.path("result").asText())) {
            throw new RuntimeException("API error: " + json);
        }

        return json.path("conversion_rates").path(target).decimalValue();
    }
}