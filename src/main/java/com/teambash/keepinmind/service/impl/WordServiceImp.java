package com.teambash.keepinmind.service.impl;

import com.teambash.keepinmind.model.Word;
import com.teambash.keepinmind.repository.WordRepository;
import com.teambash.keepinmind.service.WordService;
import com.teambash.keepinmind.shared.dto.WordDto;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log
public class WordServiceImp implements WordService {

  @Autowired private WordRepository wordRepository;

  @Autowired private ModelMapper modelMapper;

  @Override
  public WordDto createWord(WordDto dto) {
    Optional<WordDto> wordByContext = getWordByContext(dto);
    if (wordByContext.isPresent()) {
      return wordByContext.get();
    }
    log.severe("New word");
    Word newWord = new Word();
    BeanUtils.copyProperties(dto, newWord);

    return modelMapper.map(wordRepository.save(newWord), WordDto.class);
  }

  @Override
  public List<WordDto> findAllWords() {
    return wordRepository.findAll().stream()
        .map((word) -> modelMapper.map(word, WordDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public WordDto getWord(Long id) {
    return modelMapper.map(wordRepository.findById(id), WordDto.class);
  }

  @Override
  public Optional<WordDto> getWordByContext(WordDto wordDto) {
    Optional<Word> byNameAndMeaning =
        wordRepository.findByNameAndMeaning(wordDto.getName(), wordDto.getMeaning());
    if(byNameAndMeaning.isPresent()){
      return Optional.ofNullable(modelMapper.map(byNameAndMeaning.get(), WordDto.class));
    }else return Optional.ofNullable(null);
  }
}
