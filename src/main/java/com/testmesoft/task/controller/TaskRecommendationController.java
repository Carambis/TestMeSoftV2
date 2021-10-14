package com.testmesoft.task.controller;

import com.testmesoft.task.dto.TaskRecommendationDTO;
import com.testmesoft.task.service.TaskRecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task/recommendation")
public class TaskRecommendationController {

    private final TaskRecommendationService taskRecommendationService;

    public TaskRecommendationController(TaskRecommendationService taskRecommendationService) {
        this.taskRecommendationService = taskRecommendationService;
    }

    @GetMapping
    public List<TaskRecommendationDTO> getTaskRecommendations(){
        return taskRecommendationService.getTaskRecommendations();
    }
}
