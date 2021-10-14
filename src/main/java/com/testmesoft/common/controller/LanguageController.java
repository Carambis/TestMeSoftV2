package com.testmesoft.common.controller;

import com.testmesoft.common.dto.LanguageDTO;
import com.testmesoft.common.dto.RequestAllDTO;
import com.testmesoft.common.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public List<LanguageDTO> getLanguageList() {
        return languageService.getLanguageList();
    }

    @GetMapping("/{code}")
    public LanguageDTO getLanguage(@PathVariable String code) {
        return languageService.getLanguage(code);
    }
}
