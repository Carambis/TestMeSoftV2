package com.testmesoft.task.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO {
    private final Long id;
    private final String languageCode;
    private final String taskName;
    private final String header;
    private final String taskPath;
    private final String taskTypeCode;
}
