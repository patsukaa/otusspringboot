package ru.study.otusspringboot.service;

import org.springframework.stereotype.Component;
import ru.study.otusspringboot.entity.Question;
import ru.study.otusspringboot.repository.QuestionRepository;

import java.util.List;

@Component
public class QuestionService {

    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Question getQuestion() {
        return repository.getQuestion();
    }

    public List<Question> getQuestions() {
        return repository.getAll();
    }
}
