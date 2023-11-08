package org.softuni.mobilele.services;

import org.softuni.mobilele.models.dtos.CreateOfferDTO;
import org.softuni.mobilele.models.dtos.OfferDetailDTO;
import org.softuni.mobilele.models.dtos.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

    Optional<OfferDetailDTO> getOfferDetails(UUID offerUUID);

    void deleteOffer(UUID uuid);
}
