package com.testmesoft.task.service;

import com.testmesoft.task.dto.TaskDTO;
import com.testmesoft.task.entity.TaskEntity;
import com.testmesoft.task.entity.TaskSequenceEntity;
import com.testmesoft.task.entity.TaskTypeEntity;
import com.testmesoft.task.repository.TaskRepository;
import com.testmesoft.task.repository.TaskSequenceRepository;
import com.testmesoft.task.repository.TaskTypeRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final ConversionService conversionService;
    private final TaskRepository taskRepository;
    private final TaskTypeRepository taskTypeRepository;
    private final TaskSequenceRepository taskSequenceRepository;

    public TaskService(ConversionService conversionService, TaskRepository taskRepository,
                       TaskTypeRepository taskTypeRepository, TaskSequenceRepository taskSequenceRepository) {
        this.conversionService = conversionService;
        this.taskRepository = taskRepository;
        this.taskTypeRepository = taskTypeRepository;
        this.taskSequenceRepository = taskSequenceRepository;
    }

    public List<TaskDTO> findAllTask() {
        List<TaskEntity> all = taskRepository.findAll();
        List<TaskDTO> collect = all.stream().map(taskEntity -> conversionService.convert(taskEntity, TaskDTO.class)).collect(Collectors.toList());
        return collect;
    }

    public void startTest(int count, String type) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        List<TaskTypeEntity> taskTypes = taskTypeRepository.findAll();
        List<TaskSequenceEntity> taskSequenceEntityList = taskTypes.stream()
                .flatMap(taskType -> taskRepository.findRandomTasks(type, PageRequest.of(0, count)).stream())
                .map(task -> new TaskSequenceEntity(userId, task))
                .collect(Collectors.toList());
        taskSequenceRepository.saveAll(taskSequenceEntityList);
    }

    public TaskDTO nextTask() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        TaskSequenceEntity sequence = taskSequenceRepository.findFirstByUserId(userId);
        taskSequenceRepository.deleteById(sequence.getId());
        TaskEntity task = sequence.getTask();
        return conversionService.convert(task, TaskDTO.class);
    }
}