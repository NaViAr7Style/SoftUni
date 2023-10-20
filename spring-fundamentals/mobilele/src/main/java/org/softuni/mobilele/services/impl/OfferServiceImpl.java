package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.dtos.CreateOfferDTO;
import org.softuni.mobilele.models.entities.ModelEntity;
import org.softuni.mobilele.models.entities.OfferEntity;
import org.softuni.mobilele.repositories.ModelRepository;
import org.softuni.mobilele.repositories.OfferRepository;
import org.softuni.mobilele.services.OfferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        OfferEntity newOffer = map(createOfferDTO);

        ModelEntity model = modelRepository
                .findById(createOfferDTO.modelId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Model with id " + createOfferDTO.modelId() + " not found!"));

        newOffer.setModel(model);

        newOffer = offerRepository.save(newOffer);

        return newOffer.getUuid();
    }

    private OfferEntity map(CreateOfferDTO createOfferDTO) {
        OfferEntity offerEntity = new OfferEntity();

        offerEntity.setUuid(UUID.randomUUID());
        offerEntity.setDescription(createOfferDTO.description());
        offerEntity.setEngineType(createOfferDTO.engineType());
        offerEntity.setTransmissionType(createOfferDTO.transmissionType());
        offerEntity.setImageUrl(createOfferDTO.imageUrl());
        offerEntity.setMileage(createOfferDTO.mileage());
        offerEntity.setPrice(BigDecimal.valueOf(createOfferDTO.price()));
        offerEntity.setYear(createOfferDTO.year());

        return offerEntity;
    }
}
