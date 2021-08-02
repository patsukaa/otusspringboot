package ru.study.otusspringboot.reader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import ru.study.otusspringboot.config.ApplicationProperty;
import ru.study.otusspringboot.entity.Question;

import java.io.FileReader;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.util.ResourceUtils.CLASSPATH_URL_PREFIX;

@Component
@Slf4j
public class CSVQuestionReader implements QuestionReader {

    private final ApplicationProperty property;

    public CSVQuestionReader(ApplicationProperty property) {
        this.property = property;
    }


    @Override
    public List<Question> readQuestions() {

        try (FileReader fileReader = new FileReader(
                ResourceUtils.getFile(CLASSPATH_URL_PREFIX + property.getQuestionnaireFile())
        )) {

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator('@')
                    .withIgnoreQuotations(true)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();

            List<Question> questions = csvReader.readAll()
                    .stream()
                    .map(cortege -> Question.builder()
                            .text(cortege[0])
                            .correctAnswer(cortege[1])
                            .build())
                    .collect(toList());
            csvReader.close();

            return questions;

        } catch (Exception e) {
            log.error("Cannot read questions from resources", e);
            throw new RuntimeException("Cannot read questions from resources", e);
        }
    }

}
