package com.testmesoft.task.service;

import com.testmesoft.task.dto.TaskTypeDTO;
import com.testmesoft.task.entity.TaskTypeEntity;
import com.testmesoft.task.repository.TaskTypeRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskTypeService {


    private final TaskTypeRepository taskTypeRepository;
    private final ConversionService conversionService;

    public TaskTypeService(TaskTypeRepository taskTypeRepository, ConversionService conversionService) {
        this.taskTypeRepository = taskTypeRepository;
        this.conversionService = conversionService;
    }

    public List<TaskTypeDTO> getTaskTypes() {
        List<TaskTypeEntity> taskTypes = taskTypeRepository.findAll();
        return taskTypes.stream().map(taskType -> conversionService.convert(taskType, TaskTypeDTO.class)).collect(Collectors.toList());
    }
}
