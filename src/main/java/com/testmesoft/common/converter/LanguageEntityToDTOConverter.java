package com.testmesoft.common.converter;

import com.testmesoft.common.dto.LanguageDTO;
import com.testmesoft.common.entity.LanguageEntity;
import org.springframework.core.convert.converter.Converter;

public class LanguageEntityToDTOConverter implements Converter<LanguageEntity, LanguageDTO> {
    @Override
    public LanguageDTO convert(LanguageEntity source) {
        return LanguageDTO.builder()
                .code(source.getCode())
                .name(source.getName())
                .build();
    }
}
