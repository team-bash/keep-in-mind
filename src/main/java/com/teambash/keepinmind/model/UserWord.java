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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS_WORDS")
public class UserWord {

    @Id
    @Column(name = "USER_WORD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORD_ID")
    private Word word;

    @OneToMany(mappedBy = "userWords")
    private Set<QuizLog> quizLogSet = new HashSet<>();

    @OneToMany(mappedBy = "userWords")
    private Set<QuizStatus> quizStatusSet = new HashSet<>();

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

}
