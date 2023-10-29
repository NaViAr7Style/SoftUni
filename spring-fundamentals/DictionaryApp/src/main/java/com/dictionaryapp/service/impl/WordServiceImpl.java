package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.word.AddWordDTO;
import com.dictionaryapp.model.dto.word.WordDTO;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public WordServiceImpl(WordRepository wordRepository,
                           LanguageRepository languageRepository,
                           UserRepository userRepository,
                           LoggedUser loggedUser) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public void addWord(AddWordDTO addWordDTO) {
        Word newWord = new Word();
        Language language = languageRepository.findByName(addWordDTO.getLanguage());
        User user = userRepository.findByUsername(loggedUser.getUsername());

        if (language != null) {
            newWord.setTerm(addWordDTO.getTerm());
            newWord.setTranslation(addWordDTO.getTranslation());
            newWord.setExample(addWordDTO.getExample());
            newWord.setInputDate(addWordDTO.getInputDate());
            newWord.setLanguage(language);
            newWord.setAddedBy(user);

            wordRepository.save(newWord);
        }
    }

    @Override
    public void remove(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }

    @Override
    public WordHomeViewModel getHomeViewData() {
        List<WordDTO> words = wordRepository.findAllByAddedBy_Username(loggedUser.getUsername());

        WordHomeViewModel wordHomeViewModel = new WordHomeViewModel();

        List<WordDTO> frenchWords = words
                .stream()
                .filter(word -> word.languageName().equals(LanguageName.FRENCH))
                .toList();

        wordHomeViewModel.setFrenchWords(frenchWords);

        List<WordDTO> germanWords = words
                .stream()
                .filter(word -> word.languageName().equals(LanguageName.GERMAN))
                .toList();

        wordHomeViewModel.setGermanWords(germanWords);

        List<WordDTO> spanishWords = words
                .stream()
                .filter(word -> word.languageName().equals(LanguageName.SPANISH))
                .toList();

        wordHomeViewModel.setSpanishWords(spanishWords);

        List<WordDTO> italianWords = words
                .stream()
                .filter(word -> word.languageName().equals(LanguageName.ITALIAN))
                .toList();

        wordHomeViewModel.setItalianWords(italianWords);

        return wordHomeViewModel;
    }


}
