package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.dtos.BrandDTO;
import org.softuni.mobilele.models.dtos.ModelDTO;
import org.softuni.mobilele.repositories.BrandRepository;
import org.softuni.mobilele.repositories.ModelRepository;
import org.softuni.mobilele.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(ModelRepository modelRepository,
                            BrandRepository brandRepository) {

        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        //TODO: Make cleaner implementation

        return brandRepository.findAll()
                .stream()
                .map(brand -> new BrandDTO(
                        brand.getName(),
                        modelRepository.findAllByBrandId(brand.getId())
                                .stream()
                                .map(model -> new ModelDTO(model.id(), model.name()))
                                .sorted(Comparator.comparing(ModelDTO::name))
                                .collect(Collectors.toList())
                ))
                .sorted(Comparator.comparing(BrandDTO::name))
                .collect(Collectors.toList());
    }
}
