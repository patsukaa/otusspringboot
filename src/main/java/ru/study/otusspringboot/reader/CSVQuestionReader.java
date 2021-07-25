package ru.study.otusspringboot.reader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import ru.study.otusspringboot.config.ApplicationProperty;
import ru.study.otusspringboot.entity.Question;

import java.io.FileReader;
import java.util.List;

import static org.springframework.util.ResourceUtils.CLASSPATH_URL_PREFIX;

@Component
@Slf4j
public class CSVQuestionReader implements QuestionReader {

    private final ApplicationProperty property;

    public CSVQuestionReader(ApplicationProperty property) {
        this.property = property;
    }


    public List<Question> readQuestions() {

        try (FileReader fileReader = new FileReader(
                ResourceUtils.getFile(CLASSPATH_URL_PREFIX + property.getQuestionnaireFile())
        )) {

            CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(fileReader)
                    .withSeparator('@')
                    .withType(Question.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();

        } catch (Exception e) {
            log.error("Cannot read questions from resources", e);
            throw new RuntimeException("Cannot read questions from resources", e);
        }
    }

}
