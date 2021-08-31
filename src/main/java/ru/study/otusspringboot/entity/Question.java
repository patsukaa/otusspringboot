package ru.study.otusspringboot.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Question {

    private String text;

    private String correctAnswer;

}
