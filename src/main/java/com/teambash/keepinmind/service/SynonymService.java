package com.teambash.keepinmind.service;

import com.teambash.keepinmind.shared.dto.SynonymDto;
import com.teambash.keepinmind.shared.dto.WordDto;

import java.util.List;
import java.util.Optional;

public interface SynonymService {

    SynonymDto createSynonym(SynonymDto dto);

    List<SynonymDto> findAllSynonyms();

    SynonymDto getSynonym(Long id);



}
