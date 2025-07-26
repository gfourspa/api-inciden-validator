package com.gfour.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessingSummaryDTO {
        private String entityType;
        private String fileName;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private int successCount;
        private int errorCount;
        private List<String> errors;
        
        public void addError(String error) { this.errors.add(error); }
        
        public long getProcessingTimeMillis() {
            if (endTime != null && startTime != null) {
                return java.time.Duration.between(startTime, endTime).toMillis();
            }
            return 0;
        }

        public int incrementSuccessCount() {
            return ++successCount;
        }

        public int incrementErrorCount() {
            return ++errorCount;
        }
    }