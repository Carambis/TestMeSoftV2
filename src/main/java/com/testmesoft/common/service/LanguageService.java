package com.testmesoft.common.service;

import com.testmesoft.common.dto.LanguageDTO;
import com.testmesoft.common.entity.LanguageEntity;
import com.testmesoft.common.repository.LanguageRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final ConversionService conversionService;

    public LanguageService(LanguageRepository languageRepository, ConversionService conversionService) {
        this.languageRepository = languageRepository;
        this.conversionService = conversionService;
    }

    public List<LanguageDTO> getLanguageList() {
        List<LanguageEntity> languages = languageRepository.findAll();
        return languages.stream().map(language-> conversionService.convert(language, LanguageDTO.class)).collect(Collectors.toList());
    }

    public LanguageDTO getLanguage(String code) {
        LanguageEntity languageEntity = languageRepository.findDistinctByCode(code);
        return LanguageDTO.builder().code(languageEntity.getCode()).name(languageEntity.getName()).build();
    }
}
