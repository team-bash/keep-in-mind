package com.teambash.keepinmind.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TAG")
public class Tag {

    @Id
    @Column(name = "TAG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


}
