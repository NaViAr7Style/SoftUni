package com.dictionaryapp.repo;

import com.dictionaryapp.model.dto.word.WordDTO;
import com.dictionaryapp.model.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    List<WordDTO> findAllByAddedBy_Username(String username);
}
