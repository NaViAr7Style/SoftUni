package org.softuni.mobilele.repositories;

import org.softuni.mobilele.models.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
