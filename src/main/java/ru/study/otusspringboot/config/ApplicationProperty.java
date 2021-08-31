package ru.study.otusspringboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "application-property")
@Data
@Validated
public class ApplicationProperty {

    @NotBlank(message = "File name cannot be blank")
    private String questionnaireFile;
}
