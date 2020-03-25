package com.teambash.keepinmind.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "WORDS_SYNONYMS")
public class WordSynonym {

    @Id
    @Column(name = "WORD_SYNONYM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORD_ID")
    private Word word;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SYNONYM_ID")
    private Synonym synonym;
}
