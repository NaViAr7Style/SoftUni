package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.util.LoggedUser;

import java.util.List;

public class WordHomeViewModel {

    private List<WordDTO> germanWords;
    private List<WordDTO> frenchWords;
    private List<WordDTO> spanishWords;
    private List<WordDTO> italianWords;
    private LoggedUser loggedUser;

    public List<WordDTO> getGermanWords() {
        return germanWords;
    }

    public void setGermanWords(List<WordDTO> germanWords) {
        this.germanWords = germanWords;
    }

    public List<WordDTO> getFrenchWords() {
        return frenchWords;
    }

    public void setFrenchWords(List<WordDTO> frenchWords) {
        this.frenchWords = frenchWords;
    }

    public List<WordDTO> getSpanishWords() {
        return spanishWords;
    }

    public void setSpanishWords(List<WordDTO> spanishWords) {
        this.spanishWords = spanishWords;
    }

    public List<WordDTO> getItalianWords() {
        return italianWords;
    }

    public void setItalianWords(List<WordDTO> italianWords) {
        this.italianWords = italianWords;
    }
}
