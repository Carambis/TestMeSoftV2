package com.testmesoft.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestAllDTO {
    private final int page;
    private final int size;
    private final FilterDTO filterDTO;
    private final SortDTO sortDTO;
}
