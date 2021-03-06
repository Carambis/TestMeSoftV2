package com.testmesoft.task.controller;

import com.testmesoft.task.dto.TaskDTO;
import com.testmesoft.task.service.TaskService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<TaskDTO> getTasks() {
        return taskService.findAllTask();
    }

    @GetMapping("/startTest")
    public void startTest(@RequestParam("count") int count, @RequestParam("type") String type){
        taskService.startTest(count, type);
    }

    @GetMapping("/nextTask")
    public TaskDTO nextTask(){
        return taskService.nextTask();
    }
}
