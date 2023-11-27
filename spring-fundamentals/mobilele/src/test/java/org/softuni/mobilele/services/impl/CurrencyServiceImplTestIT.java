package org.softuni.mobilele.services.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.softuni.mobilele.models.dtos.ExchangeRatesDTO;
import org.softuni.mobilele.models.entities.ExchangeRateEntity;
import org.softuni.mobilele.repositories.ExchangeRateRepository;
import org.softuni.mobilele.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyServiceImplTestIT {

    @Autowired
    private CurrencyService currencyServiceToTest;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @BeforeEach
    void setUp() {
        exchangeRateRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        exchangeRateRepository.deleteAll();
    }

    @ParameterizedTest
    @MethodSource("test_Data_BGN_TO_USD")
    void test_BGN_TO_USD(Double exchangeRate, Double expectedValue) {

//        {
//            "base": "USD",
//            "rates": {
//                "BGN": 1.840515,
//                "EUR": 0.937668
//            }
//        }
//
// expected 0.54

        ExchangeRatesDTO testExchangeRate = new ExchangeRatesDTO(
                "USD",
                Map.of("BGN", BigDecimal.valueOf(exchangeRate))
        );

        currencyServiceToTest.refreshRates(testExchangeRate);

        Optional<ExchangeRateEntity> exRateUSD_BGN = exchangeRateRepository.findById("USD");

        assertTrue(exRateUSD_BGN.isPresent());
        assertEquals(
                expectedValue,
                exRateUSD_BGN.get().getRate().doubleValue(),
                1

        );
    }

    private static Stream<Arguments> test_Data_BGN_TO_USD() {
        return Stream.of(
                Arguments.of(1.840515, 0.54),
                Arguments.of(1.752345, 0.57),
                Arguments.of(1.333333, 0.75),
                Arguments.of(1.0, 1.0)
        );
    }
}