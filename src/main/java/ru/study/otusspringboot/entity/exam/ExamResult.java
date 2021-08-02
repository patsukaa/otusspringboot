package ru.study.otusspringboot.entity.exam;

import lombok.*;
import ru.study.otusspringboot.entity.Student;

@Getter
@Builder
public class ExamResult {

    private Student student;

    private long questionCount;

    private long rightAnswerCount;

    @Override
    public String toString() {

        return String.format("Студент %s ответил правильно на %d из %d вопросов",
                student.getFirstName(),
                rightAnswerCount,
                questionCount);
    }
}
