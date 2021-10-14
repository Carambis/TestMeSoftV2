package com.testmesoft.task.service;

import com.testmesoft.task.dto.AnswerDTO;
import com.testmesoft.task.entity.AnswerEntity;
import com.testmesoft.task.repository.AnswerRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final ConversionService conversionService;

    public AnswerService(AnswerRepository answerRepository, ConversionService conversionService) {
        this.answerRepository = answerRepository;
        this.conversionService = conversionService;
    }

    public List<AnswerDTO> getAnswersByTaskId(Long id) {
        List<AnswerEntity> answerEntities = answerRepository.findByTaskId(id);
        return answerEntities.stream().map(answerEntity -> conversionService.convert(answerEntity, AnswerDTO.class)).collect(Collectors.toList());
    }
}
