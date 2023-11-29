package org.softuni.mobilele.models.dtos;

import java.math.BigDecimal;

public record MoneyDTO(String currency, BigDecimal amount) {
}
