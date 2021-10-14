package com.testmesoft.task.converter;

import com.testmesoft.task.dto.TaskTypeDTO;
import com.testmesoft.task.entity.TaskTypeEntity;
import org.springframework.core.convert.converter.Converter;

public class TaskTypeEntityToDTOConverter implements Converter<TaskTypeEntity, TaskTypeDTO> {
    @Override
    public TaskTypeDTO convert(TaskTypeEntity source) {
        return TaskTypeDTO.builder()
                .code(source.getCode())
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
