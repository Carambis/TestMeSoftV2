package com.testmesoft.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDTO {
    private final String code;
    private final String name;
}
