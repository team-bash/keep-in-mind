package com.teambash.keepinmind.controller;


import com.teambash.keepinmind.service.impl.WordServiceImp;
import com.teambash.keepinmind.shared.dto.WordDto;
import com.teambash.keepinmind.shared.dto.WrapperListResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {

    private final WordServiceImp wordServiceImp;

    public WordController(WordServiceImp wordServiceImp) {
        this.wordServiceImp = wordServiceImp;
    }

    @PostMapping
    public WordDto createWord(@RequestBody WordDto newWord){
        return wordServiceImp.createWord(newWord);
    }

    @GetMapping("/{id}")
    public WordDto getWordById(@PathVariable long id){
        return wordServiceImp.getWord(id);
    }

    @GetMapping
    public WrapperListResponse<WordDto> getAllWords(){
        return new WrapperListResponse<>(this.wordServiceImp.findAllWords());
    }
}
