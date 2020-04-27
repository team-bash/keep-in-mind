package com.teambash.keepinmind.service.impl;

import com.teambash.keepinmind.exceptions.ResourceNotFound;
import com.teambash.keepinmind.model.Synonym;
import com.teambash.keepinmind.repository.SynonymRepository;
import com.teambash.keepinmind.service.SynonymService;
import com.teambash.keepinmind.shared.dto.SynonymDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
      return modelMapper.map(synonymByName.get(),SynonymDto.class);
    }
    Synonym synonym = new Synonym();
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
    Optional<Synonym> synonymFound = synonymRepository.findById(id);
    if (synonymFound.isPresent()) {
      return modelMapper.map(synonymFound.get(), SynonymDto.class);
    }else{
      throw new ResourceNotFound("Synonym");
    }
  }
}
