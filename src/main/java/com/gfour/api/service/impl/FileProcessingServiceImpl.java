package com.gfour.api.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gfour.api.dto.ProcessingSummaryDTO;
import com.gfour.api.exception.FileProcessingException;
import com.gfour.api.mapper.EntityMapper;
import com.gfour.api.mapper.EntityMapperFactory;
import com.gfour.api.repository.AffectedFeederRepository;
import com.gfour.api.repository.ConnectivityRepository;
import com.gfour.api.repository.IncidentConsistencyRepository;
import com.gfour.api.repository.IncidentFeederRepository;
import com.gfour.api.repository.NodeConnectionRepository;
import com.gfour.api.repository.NotificationRepository;
import com.gfour.api.repository.ReplacementBlockRepository;
import com.gfour.api.repository.ReplacementFeederRepository;
import com.gfour.api.service.FileProcessingService;
import com.gfour.api.utils.Constants;

/**
 * Implementation for processing text files and loading data into entities
 */
@Service
public class FileProcessingServiceImpl implements FileProcessingService {
    private static final Logger logger = LoggerFactory.getLogger(FileProcessingServiceImpl.class);
    
    private final EntityMapperFactory mapperFactory;
    private final Map<String, JpaRepository<?, ?>> repositories = new HashMap<>();
    
    @Autowired
    public FileProcessingServiceImpl(
            EntityMapperFactory mapperFactory,
            AffectedFeederRepository affectedFeederRepository,
            IncidentFeederRepository incidentFeederRepository,
            ReplacementFeederRepository replacementFeederRepository,
            NotificationRepository notificationRepository,
            ReplacementBlockRepository replacementBlockRepository,
            ConnectivityRepository connectivityRepository,
            NodeConnectionRepository nodeConnectionRepository,
            IncidentConsistencyRepository incidentConsistencyRepository) {
        
        this.mapperFactory = mapperFactory;
        
        // Register repositories for different entity types
        repositories.put("affected_feeder", affectedFeederRepository);
        repositories.put("incident_feeder", incidentFeederRepository);
        repositories.put("replacement_feeder", replacementFeederRepository);
        repositories.put("notification", notificationRepository);
        repositories.put("replacement_block", replacementBlockRepository);
        repositories.put("connectivity", connectivityRepository);
        repositories.put("node_connection", nodeConnectionRepository);
        repositories.put("incident_consistency", incidentConsistencyRepository);
    }
    
    @Override
    public List<String> getSupportedEntityTypes() {
        return new ArrayList<>(repositories.keySet());
    }
    
    @Override
    @Transactional
    public ProcessingSummaryDTO processFile(MultipartFile file, String entityType) {
        validateInputs(file, entityType);
        
        String filename = file.getOriginalFilename();
        ProcessingSummaryDTO summary = new ProcessingSummaryDTO();
        summary.setEntityType(entityType);
        summary.setFileName(filename);
        summary.setStartTime(LocalDateTime.now());
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Get the appropriate mapper and repository
            EntityMapper<?> mapper = mapperFactory.getMapper(entityType);
            JpaRepository<Object, ?> repository = getRepositoryForType(entityType);
            
            // Process the file
            List<Object> entities = processFileContent(reader, mapper, summary);
            
            // Save the entities
            try {
                saveEntities(entities, repository);
            } catch (Exception e) {
                logger.error("Failed to save entities for file {}: {}", filename, e.getMessage(), e);
                summary.incrementErrorCount();
                summary.addError("Database error: " + e.getMessage());
            }
            
            summary.setEndTime(LocalDateTime.now());
            return summary;
            
        } catch (IOException e) {
            logger.error("Failed to process file: {}", filename, e);
            throw new FileProcessingException("Failed to process file: " + filename, e);
        }
    }
    
    /**
     * Validate input parameters
     */
    private void validateInputs(MultipartFile file, String entityType) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty or null");
        }
        
        if (!repositories.containsKey(entityType.toLowerCase())) {
            throw new IllegalArgumentException("Unsupported entity type: " + entityType);
        }
    }
    
    /**
     * Get repository for the specified entity type
     */
    @SuppressWarnings("unchecked")
    private JpaRepository<Object, ?> getRepositoryForType(String entityType) {
        return (JpaRepository<Object, ?>) repositories.get(entityType.toLowerCase());
    }
    
    /**
     * Process the file content and map to entities
     */
    private <T> List<Object> processFileContent(BufferedReader reader, EntityMapper<T> mapper, 
            ProcessingSummaryDTO summary) throws IOException {
        List<Object> entities = new ArrayList<>();
        Map<String, Integer> columnMap = new HashMap<>();
        String line;
        int lineNumber = 0;
        
        // Read header line to determine column mapping
        String headerLine = reader.readLine();
        if (headerLine != null) {
            String[] headers = headerLine.split(Constants.DELIMITER);
            for (int i = 0; i < headers.length; i++) {
                columnMap.put(headers[i].trim().toLowerCase(), i);
            }
            lineNumber++;
        }
        
        // Process data lines
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            try {
                String[] values = line.split(Constants.DELIMITER, -1);
                T entity = mapper.mapToEntity(values, columnMap);
                entities.add(entity);
                summary.incrementSuccessCount();
            } catch (IllegalArgumentException e) {
                logger.warn("Invalid data format at line {}: {}", lineNumber, e.getMessage());
                summary.incrementErrorCount();
                summary.addError(String.format("Line %d: Format error - %s", lineNumber, e.getMessage()));
            } catch (Exception e) {
                logger.error("Error processing line {}: {}", lineNumber, e.getMessage(), e);
                summary.incrementErrorCount();
                summary.addError(String.format("Line %d: Unexpected error - %s", lineNumber, e.getMessage()));
            }
        }
        
        return entities;
    }
    
    /**
     * Save entities using the repository
     */
    private void saveEntities(List<Object> entities, JpaRepository<Object, ?> repository) {
        repository.saveAll(entities);
    }
}