package com.wu.app.wudemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.management.ConstructorParameters;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baseCurrency;
    private String targetCurrency;
    private BigDecimal rate;
    private LocalDateTime fetchedAt;

}
