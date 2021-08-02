package ru.study.otusspringboot.service;

import ru.study.otusspringboot.entity.Student;

public interface StudentService {

    Student createStudentFromString(String fullName);

}
