package ru.study.otusspringboot.runner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.study.otusspringboot.entity.Answer;
import ru.study.otusspringboot.entity.Question;
import ru.study.otusspringboot.entity.exam.Exam;
import ru.study.otusspringboot.entity.exam.ExamResult;
import ru.study.otusspringboot.runner.ExamHelper;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ExamHelperTest {

    private ExamHelper helper = new ExamHelper();

    @ParameterizedTest(name = "exam {0} should be equals to {1}")
    @MethodSource("provideTestData")
    void shouldReturnRightExamResult(Exam exam, ExamResult expectedResult) {
        assertThat(helper.checkExam(exam))
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(expectedResult);

    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(
                        Exam.builder().build(),
                        ExamResult.builder().questionCount(0).rightAnswerCount(0).build()
                ),

                Arguments.of(
                        Exam.builder()
                                .answers(List.of(
                                        Answer.builder()
                                                .answer("correct")
                                                .question(Question.builder()
                                                        .correctAnswer("correct")
                                                        .build())
                                                .build()
                                )).build(),
                        ExamResult.builder().questionCount(1).rightAnswerCount(1).build()
                ),

                Arguments.of(
                        Exam.builder()
                                .answers(List.of(
                                        Answer.builder()
                                                .answer("not_correct")
                                                .question(Question.builder()
                                                        .correctAnswer("correct")
                                                        .build())
                                                .build()
                                )).build(),
                        ExamResult.builder().questionCount(1).rightAnswerCount(0).build()
                )

        );
    }


}
