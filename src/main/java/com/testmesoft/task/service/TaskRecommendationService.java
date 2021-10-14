package com.testmesoft.task.service;

import com.testmesoft.task.dto.TaskRecommendationDTO;
import com.testmesoft.task.entity.TaskRecommendationEntity;
import com.testmesoft.task.repository.TaskRecommendationRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskRecommendationService {

    private final TaskRecommendationRepository taskRecommendationRepository;
    private final ConversionService conversionService;

    public TaskRecommendationService(TaskRecommendationRepository taskRecommendationRepository, ConversionService conversionService) {
        this.taskRecommendationRepository = taskRecommendationRepository;
        this.conversionService = conversionService;
    }

    public List<TaskRecommendationDTO> getTaskRecommendations() {
        List<TaskRecommendationEntity> taskRecommendations = taskRecommendationRepository.findAll();
        return taskRecommendations.stream().map(taskRecommendation -> conversionService.convert(taskRecommendation, TaskRecommendationDTO.class)).collect(Collectors.toList());
    }
}
