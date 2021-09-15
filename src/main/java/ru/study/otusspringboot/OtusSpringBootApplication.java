package ru.study.otusspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import ru.study.otusspringboot.config.ApplicationProperty;
import ru.study.otusspringboot.entity.exam.ExamResult;
import ru.study.otusspringboot.runner.ExamRunner;
import ru.study.otusspringboot.runner.ExamRunnerImp;

import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableConfigurationProperties(value = {
        ApplicationProperty.class
})
public class OtusSpringBootApplication {

    static {
        Locale.setDefault(new Locale("ru"));
    }


    public static void main(String[] args) {
        SpringApplication.run(OtusSpringBootApplication.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(OtusSpringBootApplication.class, args);
//        ExamRunner service = context.getBean(ExamRunnerImp.class);
//        ExamResult examResult = service.run();
//        System.out.println(examResult.toString());
    }

}
