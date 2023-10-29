package org.softuni.mobilele.services;

import org.softuni.mobilele.models.dtos.ExchangeRatesDTO;

public interface CurrencyService {

    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);
}
