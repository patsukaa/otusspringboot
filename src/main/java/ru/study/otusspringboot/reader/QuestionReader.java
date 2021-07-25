package ru.study.otusspringboot.reader;


import ru.study.otusspringboot.entity.Question;

import java.util.List;

public interface QuestionReader {
    List<Question> readQuestions();
}
