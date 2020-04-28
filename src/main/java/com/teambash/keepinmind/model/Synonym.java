package com.teambash.keepinmind.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
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
