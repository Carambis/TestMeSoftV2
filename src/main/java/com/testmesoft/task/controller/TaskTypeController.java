package com.testmesoft.task.controller;

import com.testmesoft.task.dto.TaskTypeDTO;
import com.testmesoft.task.service.TaskTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task/type")
public class TaskTypeController {

    private final TaskTypeService taskTypeService;

    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @GetMapping
    public List<TaskTypeDTO> getTaskTypes() {
        return taskTypeService.getTaskTypes();
    }
}
