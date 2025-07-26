package com.gfour.api.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Factory for entity mappers
 */
@Component
public class EntityMapperFactory {

    private final Map<String, EntityMapper<?>> mappers = new HashMap<>();
    
    @Autowired
    public EntityMapperFactory(
            AffectedFeederMapper affectedFeederMapper,
            IncidentFeederMapper incidentFeederMapper,
            ReplacementFeederMapper replacementFeederMapper,
            ReplacementBlockMapper replacementBlockMapper
            // Add other mappers here
    ) {
        mappers.put("affected_feeder", affectedFeederMapper);
        mappers.put("incident_feeder", incidentFeederMapper);
        mappers.put("replacement_feeder", replacementFeederMapper);
        mappers.put("replacement_block", replacementBlockMapper);
        // Register other mappers with their keys
    }
    
    /**
     * Get a mapper by entity type
     * @param entityType The entity type
     * @return The mapper
     */
    @SuppressWarnings("unchecked")
    public <T> EntityMapper<T> getMapper(String entityType) {
        EntityMapper<?> mapper = mappers.get(entityType.toLowerCase());
        if (mapper == null) {
            throw new IllegalArgumentException("Unsupported entity type: " + entityType);
        }
        return (EntityMapper<T>) mapper;
    }
}