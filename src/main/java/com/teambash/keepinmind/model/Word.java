package com.teambash.keepinmind.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "WORDS")
public class Word {

    @Id
    @Column(name = "WORD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String meaning;

    @OneToMany(mappedBy = "word")
    private Set<UserWord> userWords = new HashSet<>();

    @OneToMany(mappedBy = "word")
    private Set<WordSynonym> wordSynonyms = new HashSet<>();

}

