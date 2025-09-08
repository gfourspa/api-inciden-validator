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
import com.gfour.api.repository.BridgeRepository;
import com.gfour.api.repository.CommuneCompanySDStateRepository;
import com.gfour.api.repository.ConsumptionPointInterruptionRepository;
import com.gfour.api.repository.ConsumptionPointTopologyRepository;
import com.gfour.api.repository.EquipmentTopologyRepository;
import com.gfour.api.repository.EventDescriptionRepository;
import com.gfour.api.repository.ExternalIncidenceNodeRepository;
import com.gfour.api.repository.FailurePointRepository;
import com.gfour.api.repository.FeederIncidenceRepository;
import com.gfour.api.repository.FeederRestorationRepository;
import com.gfour.api.repository.IncidenceDerivationPointRepository;
import com.gfour.api.repository.IncidenceNodeConnectionRepository;
import com.gfour.api.repository.IncidenceNodeHeaderRepository;
import com.gfour.api.repository.IncidenceRepository;
import com.gfour.api.repository.IncidenceSubstationRepository;
import com.gfour.api.repository.IncidenceSupplyPointRepository;
import com.gfour.api.repository.InterruptionRepository;
import com.gfour.api.repository.NetworkEnergySourceRepository;
import com.gfour.api.repository.NetworkEventRepository;
import com.gfour.api.repository.NodeIncidenceRepository;
import com.gfour.api.repository.NoticeRepository;
import com.gfour.api.repository.RestorationBlockRepository;
import com.gfour.api.repository.TransformerInterruptionRepository;
import com.gfour.api.repository.TransformerTopologyRepository;
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
            BridgeRepository bridgeRepository,
            ConsumptionPointInterruptionRepository consumptionPointInterruptionRepository,
            ConsumptionPointTopologyRepository consumptionPointTopologyRepository,
            EquipmentTopologyRepository equipmentTopologyRepository,
            EventDescriptionRepository eventDescriptionRepository,
            ExternalIncidenceNodeRepository externalIncidenceNodeRepository,
            FailurePointRepository failurePointRepository,
            FeederIncidenceRepository feederIncidenceRepository,
            FeederRestorationRepository feederRestorationRepository,
            IncidenceDerivationPointRepository incidenceDerivationPointRepository,
            IncidenceNodeConnectionRepository incidenceNodeConnectionRepository,
            IncidenceNodeHeaderRepository incidenceNodeHeaderRepository,
            IncidenceRepository incidenceRepository,
            IncidenceSubstationRepository incidenceSubstationRepository,
            IncidenceSupplyPointRepository incidenceSupplyPointRepository,
            InterruptionRepository interruptionRepository,
            NetworkEnergySourceRepository networkEnergySourceRepository,
            NetworkEventRepository networkEventRepository,
            NodeIncidenceRepository nodeIncidenceRepository,
            NoticeRepository noticeRepository,
            RestorationBlockRepository restorationBlockRepository,
            TransformerInterruptionRepository transformerInterruptionRepository,
            TransformerTopologyRepository transformerTopologyRepository,
            CommuneCompanySDStateRepository communeCompanySDStateRepository) {
        
        this.mapperFactory = mapperFactory;
        
        // Register repositories for different entity types (snake_case keys to match mapper factory)
        repositories.put("affected_feeder_detail", affectedFeederRepository); // ALIMENTADOR_AFECTADO
        repositories.put("feeder_incidence", feederIncidenceRepository); // ALIMENTADOR_INCIDENCIA
        repositories.put("feeder_restoration_detail", feederRestorationRepository); // ALIMENTADOR_REPOSICION
        repositories.put("notice_detail", noticeRepository); // AVISO
        repositories.put("restoration_block", restorationBlockRepository); // BLOQUE_REPOSICION
        repositories.put("incidence_node_connection", incidenceNodeConnectionRepository); // CONEXION_NODO_INCIDENCIA
        repositories.put("event_description", eventDescriptionRepository); // DESCRIPCION_EVENTO
        repositories.put("equipment_topology", equipmentTopologyRepository); // EQUIPO_TOPOLOGIA
        repositories.put("network_event", networkEventRepository); // EVENTO_RED
        repositories.put("network_energy_source", networkEnergySourceRepository); // FUENTE_ENERGIA_RED
        repositories.put("incidence", incidenceRepository); // INCIDENCIA
        repositories.put("interruption", interruptionRepository); // INTERRUPCION
        repositories.put("consumption_point_interruption", consumptionPointInterruptionRepository); // INTERRUPCION_PUNTO_CONSUMO
        repositories.put("node_incidence", nodeIncidenceRepository); // NODO_INCIDENCIA
        repositories.put("incidence_node_header", incidenceNodeHeaderRepository); // NODO_INCIDENCIA_CABECERA
        repositories.put("external_incidence_node", externalIncidenceNodeRepository); // NODO_INCIDENCIA_EXTERNO
        repositories.put("bridge", bridgeRepository); // PUENTE
        repositories.put("consumption_point_topology", consumptionPointTopologyRepository); // PUNTO_CONSUMO_TOPOLOGIA
        repositories.put("incidence_derivation_point", incidenceDerivationPointRepository); // PUNTO_DERIVACION_INCIDENCIA
        repositories.put("failure_point", failurePointRepository); // PUNTO_FALLA
        repositories.put("incidence_supply_point", incidenceSupplyPointRepository); // PUNTO_SUMINISTRO_INCIDENCIA
        repositories.put("incidence_substation", incidenceSubstationRepository); // SUBESTACION_INCIDENCIA
        repositories.put("transformer_interruption", transformerInterruptionRepository); // TRANSFORMADOR_INTERRUPCION
        repositories.put("transformer_topology", transformerTopologyRepository); // TRANSFORMADOR_TOPOLOGIA
        repositories.put("estado_comuna_empresa_sd", communeCompanySDStateRepository); // ESTADO_COMUNA_EMPRESA_SD
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
            saveEntitiesWithErrorHandling(entities, repository, filename, summary);
            
            summary.setEndTime(LocalDateTime.now());
            return summary;
            
        } catch (IOException e) {
            logger.error("Failed to process file {}: {}", filename, e.getMessage(), e);
            throw new FileProcessingException("Failed to process file: " + filename, e);
        }
    }
    
    /**
     * Save entities with error handling
     */
    private void saveEntitiesWithErrorHandling(List<Object> entities, JpaRepository<Object, ?> repository, 
            String filename, ProcessingSummaryDTO summary) {
        try {
            saveEntities(entities, repository);
        } catch (Exception e) {
            logger.error("Failed to save entities for file {}: {}", filename, e.getMessage(), e);
            summary.incrementErrorCount();
            summary.addError("Database error: " + e.getMessage());
        }
    }
    
    /**
     * Validate input parameters
     */
    private void validateInputs(MultipartFile file, String entityType) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty or null");
        }
        
        String originalFilename = file.getOriginalFilename();
        if (originalFilename != null && !originalFilename.isEmpty()) {
            String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
            if (!extension.equals("csv") && !extension.equals("txt")) {
                throw new IllegalArgumentException("Unsupported file format. Only CSV or TXT files are allowed");
            }
        } else {
            throw new IllegalArgumentException("Invalid filename");
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