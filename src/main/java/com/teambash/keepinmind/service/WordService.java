package com.teambash.keepinmind.service;

import com.teambash.keepinmind.model.Word;
import com.teambash.keepinmind.shared.dto.WordDto;

import java.util.List;
import java.util.Optional;

public interface WordService  {

    WordDto createWord(WordDto dto);

    List<WordDto> findAllWords();

    WordDto getWord(Long id);

    Optional<WordDto> getWordByContext(WordDto wordDto);

}
