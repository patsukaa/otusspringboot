package ru.study.otusspringboot.error;

public class StudentCreationException extends RuntimeException {

    private final static String DEFAULT_MESSAGE = "can't create a student";

    public StudentCreationException() {
        super(DEFAULT_MESSAGE);
    }


    public StudentCreationException(String message) {
        super(message);
    }
}
