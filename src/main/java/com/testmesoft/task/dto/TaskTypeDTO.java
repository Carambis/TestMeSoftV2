package com.testmesoft.task.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskTypeDTO {
    private final String code;
    private final String name;
    private final String description;
}
