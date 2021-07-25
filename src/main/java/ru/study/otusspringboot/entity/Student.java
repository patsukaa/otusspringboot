package ru.study.otusspringboot.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Student {

    @Getter
    private String firstName;

    @Getter
    private String name;
}
