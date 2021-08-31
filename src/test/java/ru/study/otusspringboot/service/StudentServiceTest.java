package ru.study.otusspringboot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.study.otusspringboot.entity.Student;
import ru.study.otusspringboot.error.StudentCreationException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void shouldCreateStudent() {
        Student expectedResult = Student.builder()
                .firstName("Фамилия")
                .name("Имя")
                .build();

        assertThat(studentService.createStudentFromString("Фамилия Имя"))
                .usingRecursiveComparison()
                .isEqualTo(expectedResult);

    }

    @ParameterizedTest(name = "should throw creation exception for {0}")
    @ValueSource(strings = {" ", "тест", "тест тест тест", "1"})
    @NullSource
    @EmptySource
    void shouldThrowStudentCreationException(String wrongStudentName) {
        assertThatThrownBy(() -> studentService.createStudentFromString(wrongStudentName))
                .isInstanceOf(StudentCreationException.class);
    }


}
