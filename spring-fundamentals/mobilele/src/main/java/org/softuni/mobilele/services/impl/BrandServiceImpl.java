package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.dtos.BrandDTO;
import org.softuni.mobilele.models.dtos.ModelDTO;
import org.softuni.mobilele.repositories.BrandRepository;
import org.softuni.mobilele.services.interfaces.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        return brandRepository.findAll()
                .stream()
                .map(brand -> new BrandDTO(
                        brand.getName(),
                        brand.getModels()
                                .stream()
                                .map(model -> new ModelDTO(model.getId(), model.getName()))
                                .sorted(Comparator.comparing(ModelDTO::name))
                                .collect(Collectors.toList())
                ))
                .sorted(Comparator.comparing(BrandDTO::name))
                .collect(Collectors.toList());
    }
}
