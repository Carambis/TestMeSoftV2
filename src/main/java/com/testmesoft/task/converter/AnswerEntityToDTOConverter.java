package com.testmesoft.task.converter;

import com.testmesoft.task.dto.AnswerDTO;
import com.testmesoft.task.entity.AnswerEntity;
import org.springframework.core.convert.converter.Converter;

public class AnswerEntityToDTOConverter implements Converter<AnswerEntity, AnswerDTO> {
    @Override
    public AnswerDTO convert(AnswerEntity source) {
        return AnswerDTO.builder()
                .id(source.getId())
                .taskId(source.getTask().getId())
                .text(source.getText())
                .correct(source.getCorrect())
                .build();
    }
}
