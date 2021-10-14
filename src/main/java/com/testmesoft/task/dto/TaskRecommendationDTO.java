package com.testmesoft.task.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskRecommendationDTO {
    private final Long id;
    private final String languageCode;
    private final String taskTypeCode;
    private final int minimumValue;
    private final int maximumValue;
    private final String recommendation;
}
