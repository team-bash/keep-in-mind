package com.teambash.keepinmind.repository;

import com.teambash.keepinmind.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

  Optional<Word> findByNameAndMeaning(String name, String meaning);
}
