package ru.study.otusspringboot;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class OtusSpringBootApplicationTests {

    @Autowired
    private ConfigurableApplicationContext context;

    @Test
    void contextLoads() {
        assertThat(context.getBean(CSVReader.class))
                .isNotNull();
    }

}
