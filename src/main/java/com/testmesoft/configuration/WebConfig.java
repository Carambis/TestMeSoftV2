package com.testmesoft.configuration;

import com.testmesoft.common.converter.LanguageEntityToDTOConverter;
import com.testmesoft.task.converter.AnswerEntityToDTOConverter;
import com.testmesoft.task.converter.TaskEntityToDTOConverter;
import com.testmesoft.task.converter.TaskRecommendationEntityToDTOConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new TaskEntityToDTOConverter());
        registry.addConverter(new AnswerEntityToDTOConverter());
        registry.addConverter(new LanguageEntityToDTOConverter());
        registry.addConverter(new TaskEntityToDTOConverter());
        registry.addConverter(new TaskRecommendationEntityToDTOConverter());
    }
}