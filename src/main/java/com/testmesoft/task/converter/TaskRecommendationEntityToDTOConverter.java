package com.testmesoft.task.converter;

import com.testmesoft.task.dto.TaskRecommendationDTO;
import com.testmesoft.task.entity.TaskRecommendationEntity;
import org.springframework.core.convert.converter.Converter;

public class TaskRecommendationEntityToDTOConverter implements Converter<TaskRecommendationEntity, TaskRecommendationDTO> {
    @Override
    public TaskRecommendationDTO convert(TaskRecommendationEntity source) {
        return TaskRecommendationDTO.builder()
                .id(source.getId())
                .languageCode(source.getLanguage().getCode())
                .taskTypeCode(source.getTaskTypeEntity().getCode())
                .minimumValue(source.getMinimumValue())
                .maximumValue(source.getMaximumValue())
                .recommendation(source.getRecommendation())
                .build();
    }
}
