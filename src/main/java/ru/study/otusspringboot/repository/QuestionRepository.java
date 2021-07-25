package ru.study.otusspringboot.repository;


import ru.study.otusspringboot.entity.Question;

import java.util.List;

public interface QuestionRepository {

    Question getQuestion();

    List<Question> getAll();


}
