package com.gfour.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gfour.api.dto.ProcessingSummaryDTO;

/**
 * Service for processing text files and loading data into entities
 */
public interface FileProcessingService {
    /**
     * Process a semicolon-separated file and load data into entities
     * @param file The uploaded file
     * @param entityType The type of entity to load data into
     * @return Summary of processed records
     */
    ProcessingSummaryDTO processFile(MultipartFile file, String entityType);
    
    /**
     * Get a list of supported entity types
     * @return List of supported entity types
     */
    List<String> getSupportedEntityTypes();
}