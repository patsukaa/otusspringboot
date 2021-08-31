package ru.study.otusspringboot.repository;


import org.springframework.stereotype.Component;
import ru.study.otusspringboot.entity.Question;
import ru.study.otusspringboot.reader.QuestionReader;

import java.util.List;

@Component
public class QuestionCSVRepository implements QuestionRepository {

    private final QuestionReader reader;

    public QuestionCSVRepository(QuestionReader reader) {
        this.reader = reader;
    }

    @Override
    public Question getQuestion() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Question> getAll() {
        return reader.readQuestions();
    }


}
