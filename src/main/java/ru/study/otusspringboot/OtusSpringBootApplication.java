package ru.study.otusspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.study.otusspringboot.config.ApplicationProperty;
import ru.study.otusspringboot.entity.exam.ExamResult;
import ru.study.otusspringboot.runner.ExamRunner;
import ru.study.otusspringboot.runner.ExamRunnerImp;

@SpringBootApplication
@EnableConfigurationProperties(value = {
        ApplicationProperty.class
})
public class OtusSpringBootApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OtusSpringBootApplication.class, args);
        ExamRunner service = context.getBean(ExamRunnerImp.class);
        ExamResult examResult = service.run();
        System.out.println(examResult.toString());
    }

}
