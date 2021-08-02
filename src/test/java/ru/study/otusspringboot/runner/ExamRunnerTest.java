package ru.study.otusspringboot.runner;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.study.otusspringboot.entity.Question;
import ru.study.otusspringboot.entity.Student;
import ru.study.otusspringboot.entity.exam.ExamResult;
import ru.study.otusspringboot.reader.ConsoleReader;
import ru.study.otusspringboot.service.QuestionService;
import ru.study.otusspringboot.service.StudentService;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ExamRunnerTest {

    @MockBean
    private QuestionService questionService;

    @MockBean
    private ExamHelper examHelper;

    @MockBean
    private ConsoleReader reader;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ExamRunner runner;


    @Test
    public void studentShouldPassExam() {
        String studentName = "Иванов Иван";

        when(reader.readAnswer("Как тебя зовут(Ф И)?")).thenReturn(studentName);

        when(studentService.createStudentFromString(studentName)).thenCallRealMethod();

        when(questionService.getQuestions()).thenReturn(getQuestions());

        when(reader.readAnswer("1+1")).thenReturn("2");
        when(reader.readAnswer("2+2")).thenReturn("4");
        when(reader.readAnswer("3+3")).thenReturn("6");

        when(examHelper.checkExam(any())).thenCallRealMethod();

        ExamResult expectedResult = ExamResult.builder()
                .questionCount(3)
                .rightAnswerCount(3)
                .student(Student.builder()
                        .firstName("Иванов")
                        .name("Иван")
                        .build())
                .build();


        assertThat(runner.run())
                .usingRecursiveComparison()
                .isEqualTo(expectedResult);


    }

    private List<Question> getQuestions() {
        return List.of(
                Question.builder()
                        .text("1+1")
                        .correctAnswer("2")
                        .build(),

                Question.builder()
                        .text("2+2")
                        .correctAnswer("4")
                        .build(),

                Question.builder()
                        .text("3+3")
                        .correctAnswer("6")
                        .build()
        );
    }


}
