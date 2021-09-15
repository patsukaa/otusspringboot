package ru.study.otusspringboot.events;

import lombok.RequiredArgsConstructor;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.study.otusspringboot.entity.exam.ExamResult;
import ru.study.otusspringboot.runner.ExamRunner;


@RequiredArgsConstructor
@ShellComponent
public class ApplicationCommands {

    private final ExamRunner examRunner;


    @ShellMethod(value = "Run exam", key = {"e"})
    public String exam() {
        ExamResult result = examRunner.run();
        return String.format("Student get next result: total questions %s correct answers %s", result.getQuestionCount(),
                result.getRightAnswerCount());
    }

}
