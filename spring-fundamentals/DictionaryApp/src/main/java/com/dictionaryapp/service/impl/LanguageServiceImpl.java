package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.language.LanguageDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageDTO> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();

        return languages
                .stream()
                .map(language -> {
                    LanguageDTO languageDTO = new LanguageDTO();
                    languageDTO.setName(language.getName().toString());
                    return languageDTO;
                })
                .sorted(Comparator.comparing(LanguageDTO::getName))
                .collect(Collectors.toList());
    }
}
