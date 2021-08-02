package ru.study.otusspringboot.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Student {

    @Getter
    private final String firstName;

    @Getter
    private final String name;
}
