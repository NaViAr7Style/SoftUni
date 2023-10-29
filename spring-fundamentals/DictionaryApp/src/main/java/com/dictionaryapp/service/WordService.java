package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.word.AddWordDTO;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;

public interface WordService {

    void addWord(AddWordDTO addWordDTO);

    void remove(Long id);

    void removeAll();

    WordHomeViewModel getHomeViewData();
}
