package org.softuni.mobilele.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "exchange_rates")
@Getter
@Setter
public class ExchangeRateEntity {

    @Id
    @NotNull
    private String currency;

    @NotNull
    private BigDecimal rate;
}
