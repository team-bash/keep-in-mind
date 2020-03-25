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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
@Table(name = "QUIZ_LOG")
public class QuizLog {

    @Id
    @Column(name = "QUIZ_LOG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean isRightAnswer;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_WORD_ID")
    private UserWord userWords;
}
