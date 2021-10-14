package com.testmesoft.task.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDTO {
    private final Long id;
    private final Long taskId;
    private final String text;
    private final boolean correct;
}
