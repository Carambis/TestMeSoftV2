package com.testmesoft.task.converter;

import com.testmesoft.task.dto.TaskDTO;
import com.testmesoft.task.entity.TaskEntity;
import org.springframework.core.convert.converter.Converter;

public class TaskEntityToDTOConverter implements Converter<TaskEntity, TaskDTO> {
    @Override
    public TaskDTO convert(TaskEntity source) {
        return TaskDTO.builder()
                .id(source.getId())
                .languageCode(source.getLanguage().getCode())
                .taskName(source.getTaskName())
                .header(source.getHeader())
                .taskPath(source.getTaskPath())
                .taskTypeCode(source.getType().getCode())
                .build();
    }
}
