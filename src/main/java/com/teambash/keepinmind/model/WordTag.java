package com.teambash.keepinmind.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "WORD_TAG")
public class WordTag {

    @Id
    @Column(name = "WORD_TAG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORD_ID")
    private Word word;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;
}
