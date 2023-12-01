package org.softuni.mobilele.testUtils;

import org.softuni.mobilele.models.entities.ExchangeRateEntity;
import org.softuni.mobilele.models.entities.UserEntity;
import org.softuni.mobilele.repositories.ExchangeRateRepository;
import org.softuni.mobilele.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TestDataUtil {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private OfferRepository offerRepository;

    public void createExchangeRate(String currency, BigDecimal rate) {
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();

        exchangeRateEntity.setCurrency(currency);
        exchangeRateEntity.setRate(rate);

        exchangeRateRepository.save(exchangeRateEntity);
    }

    public String createTestOffer(UserEntity owner) {
        return null;
    }

    public void cleanAllTestData() {
        exchangeRateRepository.deleteAll();
    }
}
