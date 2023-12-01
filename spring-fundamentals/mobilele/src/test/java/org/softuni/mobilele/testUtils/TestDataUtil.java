package org.softuni.mobilele.testUtils;

import org.softuni.mobilele.models.entities.*;
import org.softuni.mobilele.models.enums.EngineTypeEnum;
import org.softuni.mobilele.models.enums.TransmissionTypeEnum;
import org.softuni.mobilele.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class TestDataUtil {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    public void createExchangeRate(String currency, BigDecimal rate) {
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();

        exchangeRateEntity.setCurrency(currency);
        exchangeRateEntity.setRate(rate);

        exchangeRateRepository.save(exchangeRateEntity);
    }

    public OfferEntity createTestOffer(UserEntity owner) {
        BrandEntity testBrand = new BrandEntity();
        testBrand.setName("Test Brand");
        brandRepository.save(testBrand);

        ModelEntity testModel = new ModelEntity();
        testModel.setName("Test Model1");
        testModel.setBrand(testBrand);
        modelRepository.save(testModel);

        OfferEntity offer = new OfferEntity();

        offer.setModel(testModel);
        offer.setUuid(UUID.randomUUID());
        offer.setImageUrl("https://google.com");
        offer.setPrice(BigDecimal.valueOf(1000));
        offer.setYear(2020);
        offer.setDescription("Test Description");
        offer.setEngine(EngineTypeEnum.Diesel);
        offer.setMileage(10000);
        offer.setTransmission(TransmissionTypeEnum.Automatic);
        offer.setSeller(owner);

        offerRepository.save(offer);

        return offer;
    }

    public void cleanUp() {
        exchangeRateRepository.deleteAll();
        offerRepository.deleteAll();
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }
}
