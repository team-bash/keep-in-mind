package com.teambash.keepinmind.model;

import lombok.Builder;
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

@Builder
@Data
@Entity
@Table(name = "SYNONYM")
public class Synonym {

    @Id
    @Column(name = "SYNONYM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "synonym")
    private Set<WordSynonym> wordSynonyms = new HashSet<>();
}
