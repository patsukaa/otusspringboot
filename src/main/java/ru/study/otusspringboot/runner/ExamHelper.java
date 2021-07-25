package ru.study.otusspringboot.runner;

import org.springframework.stereotype.Component;
import ru.study.otusspringboot.entity.exam.Exam;
import ru.study.otusspringboot.entity.exam.ExamResult;

@Component
public class ExamHelper {

    public ExamResult checkExam(Exam exam) {
        long count = exam.getAnswers().size();
        long rightAnswersCount = exam.getAnswers()
                .stream()
                .filter(answer -> answer.question.getCorrectAnswer().equalsIgnoreCase(answer.answer))
                .count();
        return new ExamResult(count, rightAnswersCount);
    }

}
