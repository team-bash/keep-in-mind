package com.teambash.keepinmind.service.impl;

import com.teambash.keepinmind.model.Synonym;
import com.teambash.keepinmind.repository.SynonymRepository;
import com.teambash.keepinmind.service.SynonymService;
import com.teambash.keepinmind.shared.dto.SynonymDto;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log
public class SynonymServiceImp implements SynonymService {

  private final SynonymRepository synonymRepository;
  private final ModelMapper modelMapper;
  
  public SynonymServiceImp(SynonymRepository synonymRepository, ModelMapper modelMapper) {
    this.synonymRepository = synonymRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public SynonymDto createSynonym(SynonymDto dto) {
    Optional<Synonym> synonymByName = synonymRepository.findByName(dto.getName());
    if (synonymByName.isPresent()) {
      return modelMapper.map(Synonym.builder().build(), SynonymDto.class);
    }
    Synonym synonym = Synonym.builder().build();
    BeanUtils.copyProperties(dto, synonym);

    return modelMapper.map(synonymRepository.save(synonym), SynonymDto.class);
  }

  @Override
  public List<SynonymDto> findAllSynonyms() {
    return synonymRepository.findAll().stream()
        .map((synonym) -> modelMapper.map(synonym, SynonymDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public SynonymDto getSynonym(Long id) {
    return modelMapper.map(synonymRepository.findById(id), SynonymDto.class);
  }
}
