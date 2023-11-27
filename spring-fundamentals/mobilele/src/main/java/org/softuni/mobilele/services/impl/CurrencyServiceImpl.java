package org.softuni.mobilele.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softuni.mobilele.models.dtos.ExchangeRatesDTO;
import org.softuni.mobilele.models.entities.ExchangeRateEntity;
import org.softuni.mobilele.repositories.ExchangeRateRepository;
import org.softuni.mobilele.services.CurrencyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final ExchangeRateRepository exchangeRateRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    public CurrencyServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public void refreshRates(ExchangeRatesDTO exchangeRatesDTO) {

        LOGGER.info("Exchange rates received {}", exchangeRatesDTO);

        BigDecimal BGN_TO_USD = getExchangeRate(exchangeRatesDTO, "BGN", "USD").orElse(null);
        BigDecimal BGN_TO_EUR = getExchangeRate(exchangeRatesDTO, "BGN", "EUR").orElse(null);

        if (BGN_TO_USD != null) {
            ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
            exchangeRateEntity.setCurrency("USD");
            exchangeRateEntity.setRate(BGN_TO_USD);

            exchangeRateRepository.save(exchangeRateEntity);
        } else {
            LOGGER.error("Unable to get exchange rate for BGN to USD");
        }

        if (BGN_TO_EUR != null) {
            ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
            exchangeRateEntity.setCurrency("EUR");
            exchangeRateEntity.setRate(BGN_TO_EUR);

            exchangeRateRepository.save(exchangeRateEntity);
        } else {
            LOGGER.error("Unable to get exchange rate for BGN to EUR");
        }

        LOGGER.info("Rates refreshed...");
    }

    private static Optional<BigDecimal> getExchangeRate(
            ExchangeRatesDTO exchangeRatesDTO,
            String from,
            String to) {

        Objects.requireNonNull(from, "'From' currency cannot be null!");
        Objects.requireNonNull(to, "'To' currency cannot be null!");

//        {
//            "base": "USD",
//            "rates": {
//                "BGN": 1.840515,
//                "EUR": 0.937668
//            }
//        }

        // e.g. USD -> USD
        if (Objects.equals(from, to)) {
            return Optional.of(BigDecimal.ONE);
        }

        Map<String, BigDecimal> currencyRates = exchangeRatesDTO.rates();
        String baseCurrency = exchangeRatesDTO.base();

        if (from.equals(baseCurrency)) {
            // e.g. USD -> BGN
            if (currencyRates.containsKey(to)) {
                return Optional.of(currencyRates.get(to));
            }
        } else if (to.equals(baseCurrency)) {
            // e.g. BGN -> USD
            if (currencyRates.containsKey(from)) {
                return Optional.of(BigDecimal.ONE.divide(
                        currencyRates.get(from),
                        5,
                        RoundingMode.DOWN
                ));
            }
        } else if (currencyRates.containsKey(from) &&
                currencyRates.containsKey(to)){
            // e.g. BGN -> EUR

            return Optional.of(
                    currencyRates
                            .get(to)
                            .divide(
                                    currencyRates.get(from),
                                    3,
                                    RoundingMode.DOWN)
            );
        }

        return Optional.empty();
    }
}
