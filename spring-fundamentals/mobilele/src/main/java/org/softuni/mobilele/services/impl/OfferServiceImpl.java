package org.softuni.mobilele.services.impl;

import jakarta.transaction.Transactional;
import org.softuni.mobilele.models.dtos.CreateOfferDTO;
import org.softuni.mobilele.models.dtos.OfferDetailDTO;
import org.softuni.mobilele.models.dtos.OfferSummaryDTO;
import org.softuni.mobilele.models.entities.ModelEntity;
import org.softuni.mobilele.models.entities.OfferEntity;
import org.softuni.mobilele.models.entities.UserEntity;
import org.softuni.mobilele.repositories.ModelRepository;
import org.softuni.mobilele.repositories.OfferRepository;
import org.softuni.mobilele.repositories.UserRepository;
import org.softuni.mobilele.services.MonitoringService;
import org.softuni.mobilele.services.OfferService;
import org.softuni.mobilele.services.exceptions.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final MonitoringService monitoringService;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelRepository modelRepository,
                            UserRepository userRepository,
                            MonitoringService monitoringService) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.monitoringService = monitoringService;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO, UserDetails seller) {

        OfferEntity newOffer = map(createOfferDTO);

        ModelEntity model = modelRepository
                .findById(createOfferDTO.modelId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Model with id " + createOfferDTO.modelId() + " not found!"));

        UserEntity user = userRepository
                .findByEmail(seller.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User with email '" +
                                                                    seller.getUsername() +
                                                                    "' not found!"));

        newOffer.setModel(model);
        newOffer.setSeller(user);

        newOffer = offerRepository.save(newOffer);

        return newOffer.getUuid();
    }

    @Override
    public Page<OfferSummaryDTO> getAllOffers(Pageable pageable) {

        monitoringService.logOfferSearch();

        return offerRepository
                .findAll(pageable)
                .map(OfferServiceImpl::mapAsSummary);
    }

    @Override
    public Optional<OfferDetailDTO> getOfferDetails(UUID offerUUID) {
        return offerRepository
                .findByUuid(offerUUID)
                .map(OfferServiceImpl::mapAsDetails);
    }

    @Override
    @Transactional
    public void deleteOffer(UUID uuid) {
        offerRepository.deleteByUuid(uuid);
    }

    private static OfferDetailDTO mapAsDetails(OfferEntity offerEntity) {
        // TODO: Reuse
        return new OfferDetailDTO(
                offerEntity.getUuid().toString(),
                offerEntity.getModel().getBrand().getName(),
                offerEntity.getModel().getName(),
                offerEntity.getYear(),
                offerEntity.getMileage(),
                offerEntity.getPrice(),
                offerEntity.getEngine(),
                offerEntity.getTransmission(),
                offerEntity.getImageUrl()
        );
    }

    private static OfferSummaryDTO mapAsSummary(OfferEntity offerEntity) {
        return new OfferSummaryDTO(
                offerEntity.getUuid().toString(),
                offerEntity.getModel().getBrand().getName(),
                offerEntity.getModel().getName(),
                offerEntity.getYear(),
                offerEntity.getMileage(),
                offerEntity.getPrice(),
                offerEntity.getEngine(),
                offerEntity.getTransmission(),
                offerEntity.getImageUrl()
        );
    }

    private static OfferEntity map(CreateOfferDTO createOfferDTO) {
        OfferEntity offerEntity = new OfferEntity();

        offerEntity.setUuid(UUID.randomUUID());
        offerEntity.setDescription(createOfferDTO.description());
        offerEntity.setEngine(createOfferDTO.engine());
        offerEntity.setTransmission(createOfferDTO.transmission());
        offerEntity.setImageUrl(createOfferDTO.imageUrl());
        offerEntity.setMileage(createOfferDTO.mileage());
        offerEntity.setPrice(BigDecimal.valueOf(createOfferDTO.price()));
        offerEntity.setYear(createOfferDTO.year());

        return offerEntity;
    }
}
