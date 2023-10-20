package org.softuni.mobilele.repositories;

import org.softuni.mobilele.models.dtos.ModelDTO;
import org.softuni.mobilele.models.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    List<ModelDTO> findAllByBrandId (Long id);

}
