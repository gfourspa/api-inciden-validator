package com.gfour.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationErrorDTO {
    private String table;
    private String comparedTable;
    private String incidenceId;
    private String errorType;
    private String description;
}
