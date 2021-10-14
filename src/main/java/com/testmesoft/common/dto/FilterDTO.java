package com.testmesoft.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilterDTO {
    private final String field;
    private final String value;
}
