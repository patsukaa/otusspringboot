package ru.study.otusspringboot.entity.exam;

import lombok.Builder;
import lombok.Getter;
import ru.study.otusspringboot.entity.Answer;
import ru.study.otusspringboot.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Exam {

    @Getter
    private Student student;

    @Getter
    @Builder.Default
    private List<Answer> answers = new ArrayList<>();
}
