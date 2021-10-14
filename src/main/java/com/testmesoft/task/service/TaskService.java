package com.testmesoft.task.service;

import com.testmesoft.task.dto.TaskDTO;
import com.testmesoft.task.entity.TaskEntity;
import com.testmesoft.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final ConversionService conversionService;
    private final TaskRepository taskRepository;

    public TaskService(ConversionService conversionService, TaskRepository taskRepository) {
        this.conversionService = conversionService;
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> findAllTask(){
        List<TaskEntity> all = taskRepository.findAll();
        List<TaskDTO> collect = all.stream().map(taskEntity -> conversionService.convert(taskEntity, TaskDTO.class)).collect(Collectors.toList());
        return collect;
    }
}
