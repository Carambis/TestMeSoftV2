package com.testmesoft.common.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@Builder
public class SortDTO {
    private final List<String> fields;
    private final Sort.Direction direction;
}
