package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.language.LanguageDTO;

import java.util.List;

public interface LanguageService {
    List<LanguageDTO> getAllLanguages();
}
