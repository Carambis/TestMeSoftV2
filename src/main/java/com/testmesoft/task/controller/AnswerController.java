package com.testmesoft.task.controller;

import com.testmesoft.task.dto.AnswerDTO;
import com.testmesoft.task.service.AnswerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task/answer")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/task/{id}")
    public List<AnswerDTO> getAnswersByTaskId(@PathVariable(name = "id") Long id) {
       return answerService.getAnswersByTaskId(id);
    }
}
