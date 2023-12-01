package org.softuni.mobilele.services.interfaces;

import org.softuni.mobilele.models.dtos.ConvertRequestDTO;
import org.softuni.mobilele.models.dtos.ExchangeRatesDTO;
import org.softuni.mobilele.models.dtos.MoneyDTO;

public interface CurrencyService {

    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);

    MoneyDTO convert(ConvertRequestDTO convertRequestDTO);
}
