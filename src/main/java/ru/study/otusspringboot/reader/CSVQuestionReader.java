package ru.study.otusspringboot.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.study.otusspringboot.entity.Question;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@Slf4j
public class CSVQuestionReader implements QuestionReader {

    private final CSVReader csvReader;

    public CSVQuestionReader(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public List<Question> readQuestions() {
        try {
            return csvReader
                    .readAll()
                    .stream()
                    .map(cortege -> Question.builder()
                            .text(cortege[0])
                            .correctAnswer(cortege[1])
                            .build())
                    .collect(toList());
        } catch (CsvException | IOException e) {
            log.error("can't read questions", e);
            throw new RuntimeException("can't read questions", e);
        }

    }

}
