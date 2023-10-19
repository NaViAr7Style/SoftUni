package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.dtos.CreateOfferDTO;
import org.softuni.mobilele.repositories.OfferRepository;
import org.softuni.mobilele.services.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        //TODO - create offer
        throw new UnsupportedOperationException("Coming soon!");
    }
}
