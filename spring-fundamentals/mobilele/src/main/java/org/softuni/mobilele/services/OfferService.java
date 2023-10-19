package org.softuni.mobilele.services;

import org.softuni.mobilele.models.dtos.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);
}
