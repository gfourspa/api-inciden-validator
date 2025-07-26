package com.gfour.api.dto;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationResultDTO {
    private String processName;
    private boolean success;
    private int recordsProcessed;
    private List<ValidationErrorDTO> errors;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long executionTimeMillis;
    
    public void calculateExecutionTime() {
        if (startTime != null && endTime != null) {
            executionTimeMillis = Duration.between(startTime, endTime).toMillis();
        }
    }
}
