package org.softuni.mobilele.repositories;

import org.softuni.mobilele.models.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
