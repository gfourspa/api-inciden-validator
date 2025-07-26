package com.gfour.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gfour.api.dto.ProcessingSummaryDTO;
import com.gfour.api.exception.FileProcessingException;
import com.gfour.api.service.FileProcessingService;

/**
 * Controller for handling file uploads and processing
 */
@RestController
@RequestMapping("/api/files")
public class FileUploadController {
    
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    
    @Autowired
    FileProcessingService fileProcessingService;
    
    /**
     * Get list of supported entity types for file processing
     * 
     * @return List of supported entity types
     */
    @GetMapping("/entity-types")
    public ResponseEntity<List<String>> getSupportedEntityTypes() {
        logger.debug("REST request to get supported entity types");
        return ResponseEntity.ok(fileProcessingService.getSupportedEntityTypes());
    }
    
    /**
     * Upload and process a file for a specific entity type
     * 
     * @param file the file to process
     * @param entityType the type of entity to map the file data to
     * @return processing summary with results
     */
    @PostMapping("/upload")
    public ResponseEntity<ProcessingSummaryDTO> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("entityType") String entityType) {
        
        logger.info("REST request to upload and process file for entity type: {}", entityType);
        
        try {
            ProcessingSummaryDTO summary = fileProcessingService.processFile(file, entityType);
            return ResponseEntity.ok(summary);
        } catch (IllegalArgumentException e) {
            // Invalid input parameters
            logger.warn("Invalid request parameters: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (FileProcessingException e) {
            // File processing error
            logger.error("Error processing file", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Exception handler for FileProcessingException
     */
    @ExceptionHandler(FileProcessingException.class)
    public ResponseEntity<String> handleFileProcessingException(FileProcessingException e) {
        logger.error("File processing error", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("File processing error: " + e.getMessage());
    }
    
    /**
     * Exception handler for IllegalArgumentException
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.warn("Invalid argument", e);
        return ResponseEntity
                .badRequest()
                .body("Invalid request: " + e.getMessage());
    }
}