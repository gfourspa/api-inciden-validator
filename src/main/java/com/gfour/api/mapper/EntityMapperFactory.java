package com.gfour.api.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Factory for entity mappers. Auto-discovers all EntityMapper beans and
 * registers them using a snake_case key derived from the bean name
 * (e.g., affectedFeederMapper -> affected_feeder).
 */
@Component
public class EntityMapperFactory {

    private final Map<String, EntityMapper<?>> mappers = new HashMap<>();

    @Autowired
    public EntityMapperFactory(Map<String, EntityMapper<?>> mapperBeans) {
        // mapperBeans: key = Spring bean name (e.g., affectedFeederMapper)
        mapperBeans.forEach((beanName, mapper) -> {
            String key = toSnakeCase(trimSuffix(beanName, "Mapper"));
            mappers.put(key, mapper);
        });
    }

    private String trimSuffix(String value, String suffix) {
        return value != null && value.endsWith(suffix) ? value.substring(0, value.length() - suffix.length()) : value;
    }

    private String toSnakeCase(String camelCase) {
        if (camelCase == null) return null;
        return camelCase.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    /**
     * Get a mapper by entity type
     * @param entityType The entity type (snake_case)
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