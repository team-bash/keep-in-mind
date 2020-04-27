package com.teambash.keepinmind.service;

import com.teambash.keepinmind.shared.dto.SynonymDto;

import java.util.List;

public interface SynonymService {

  SynonymDto createSynonym(SynonymDto dto);

  List<SynonymDto> findAllSynonyms();

  SynonymDto getSynonym(Long id);
}
