package ru.study.otusspringboot.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Question {

    @CsvBindByName(column = "text", required = true)
    private String text;

    @CsvBindByName(column = "correctAnswer", required = true)
    private String correctAnswer;

}
