package ru.study.otusspringboot.runner;

import org.springframework.stereotype.Component;
import ru.study.otusspringboot.entity.Answer;
import ru.study.otusspringboot.entity.Question;
import ru.study.otusspringboot.entity.Student;
import ru.study.otusspringboot.entity.exam.Exam;
import ru.study.otusspringboot.entity.exam.ExamResult;
import ru.study.otusspringboot.reader.ConsoleReader;
import ru.study.otusspringboot.service.QuestionService;
import ru.study.otusspringboot.service.StudentService;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

@Component
public class ExamRunnerImp implements ExamRunner {

    private QuestionService service;
    private ExamHelper helper;
    private ConsoleReader reader;
    private StudentService studentService;

    public ExamRunnerImp(QuestionService service,
                         ExamHelper helper,
                         ConsoleReader reader,
                         StudentService studentService) {
        this.service = service;
        this.helper = helper;
        this.reader = reader;
        this.studentService = studentService;
    }

    @Override
    public ExamResult run() {
        String studentName = reader.readAnswer("Как тебя зовут(Ф И)?");
        Student student = studentService.createStudentFromString(studentName);

        List<Question> questions = service.getQuestions();

        Exam exam = questions
                .stream()
                .map(question -> {
                    String answer = reader.readAnswer(question.getText());
                    return Answer.builder()
                            .question(question)
                            .answer(answer)
                            .build();
                })
                .collect(
                        getExamSupplier(student),
                        getAnswerToExamAdder(),
                        getExamsCombiner()
                );

        return helper.checkExam(exam);

    }


    private Supplier<Exam> getExamSupplier(Student student) {
        return () -> Exam.builder()
                .student(student)
                .build();
    }

    private BiConsumer<Exam, Answer> getAnswerToExamAdder() {
        return (exam, answer) -> exam.getAnswers().add(answer);
    }

    private BiConsumer<Exam, Exam> getExamsCombiner() {
        return (exam, exam2) -> exam.getAnswers().addAll(exam2.getAnswers());
    }

}
