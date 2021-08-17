package ru.study.otusspringboot.reader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.SneakyThrows;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

@Configuration
public class CSVQuestionReaderConfig {

    @Bean
    public CSVParser getCSVParser() {
        return new CSVParserBuilder()
                .withSeparator('@')
                .withIgnoreQuotations(true)
                .build();
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        final ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("localization/messages");
        return source;
    }

    @Bean
    @SneakyThrows
    public CSVReader getCsvReader(MessageSource messageSource,
                                  CSVParser parser) {
        String fileName = messageSource.getMessage("questionFile", null, Locale.getDefault());
        if (fileName.isBlank())
            throw new RuntimeException("File name cannot be blank");
        return new CSVReaderBuilder(
                Files.newBufferedReader(
                        Paths.get(
                                ClassLoader.getSystemResource(fileName).toURI()
                        ))
        )
                .withSkipLines(0)
                .withCSVParser(parser)
                .build();
    }

}
