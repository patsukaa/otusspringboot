package ru.study.otusspringboot.reader;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {

    private final Scanner scanner = new Scanner(System.in);

    public String readAnswer(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

}
