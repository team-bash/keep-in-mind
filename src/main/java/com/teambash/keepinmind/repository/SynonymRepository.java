package com.teambash.keepinmind.repository;

import com.teambash.keepinmind.model.Synonym;
import com.teambash.keepinmind.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SynonymRepository extends JpaRepository<Synonym, Long> {

  Optional<Synonym> findByName(String name);

}
