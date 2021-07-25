package ru.study.otusspringboot.entity.exam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamResult {

    private long questionCount;

    private long rightAnswerCount;
}
