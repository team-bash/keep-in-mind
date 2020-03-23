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
import java.util.Date;

@Data
@Entity
@Table(name = "QUIZ_STATUS")
public class QuizStatus {

    @Id
    @Column(name = "QUIZ_STATUS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date presentationDate;
    private Boolean isLearned;
    private Integer rightAnswerCount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_WORD_ID")
    private UserWord userWords;
}
