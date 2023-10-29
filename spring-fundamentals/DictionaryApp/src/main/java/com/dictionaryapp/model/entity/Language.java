package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language", targetEntity = Word.class)
    private List<Word> words;

    private void setDescription(LanguageName name) {
        String description = "";

        switch (name) {

            case GERMAN -> description = "A West Germanic languageName, is spoken by over 90 million people worldwide. " +
                    "Known for its complex grammar and compound words, " +
                    "it's the official languageName of Germany and widely used in Europe.";

            case SPANISH -> description = "A Romance languageName, is spoken by over 460 million people worldwide. " +
                    "It boasts a rich history, diverse dialects, " +
                    "and is known for its melodious sound, making it a global cultural treasure.";

            case FRENCH -> description = "A Romance languageName spoken worldwide, " +
                    "known for its elegance and cultural richness. " +
                    "It's the official languageName of France and numerous nations, " +
                    "famed for its cuisine, art, and literature.";

            case ITALIAN -> description = "A Romance languageName spoken in Italy and parts of Switzerland, " +
                    "with rich cultural heritage. Known for its melodious sounds, " +
                    "it's a gateway to Italian art, cuisine, and history.";
        }

        this.description = description;
    }

    public LanguageName getName() {
        return name;
    }

    public void setName(LanguageName name) {
        this.name = name;
        setDescription(name);
    }

    public String getDescription() {
        return description;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
