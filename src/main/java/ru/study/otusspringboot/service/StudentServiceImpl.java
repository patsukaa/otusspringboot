package ru.study.otusspringboot.service;

import org.springframework.stereotype.Component;
import ru.study.otusspringboot.entity.Student;
import ru.study.otusspringboot.error.StudentCreationException;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class StudentServiceImpl implements StudentService {

    private static final String FIRST_NAME_GROUP = "firstName";
    private static final String NAME_GROUP = "name";

    private static final String RU_FIO_PATTERN_STRING =
            "^(?<" + FIRST_NAME_GROUP + ">[а-яА-я]+)\\s{1}(?<" + NAME_GROUP + ">[а-яА-я]+)$";

    private static final Pattern RU_FIO_PATTERN = Pattern.compile(RU_FIO_PATTERN_STRING);

    @Override
    public Student createStudentFromString(String fullName) {
        return Optional.ofNullable(fullName)
                .map(studentName -> {
                    Matcher matcher = RU_FIO_PATTERN.matcher(fullName);

                    if (matcher.matches()) {
                        return Student.builder()
                                .firstName(matcher.group(FIRST_NAME_GROUP))
                                .name(matcher.group(NAME_GROUP))
                                .build();
                    } else {
                        throw new StudentCreationException("student name is not match to pattern");
                    }
                })
                .orElseThrow(StudentCreationException::new);
    }
}
