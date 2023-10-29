package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.model.enums.LanguageName;

import java.time.LocalDate;

public record WordDTO(String term,
                      String translation,
                      String example,
                      LocalDate inputDate,
                      LanguageName languageName,
                      Long addedById) {

}
