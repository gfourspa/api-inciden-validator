package com.gfour.api.mapper;

import java.util.Map;

/**
 * Base interface for mapping raw file data to entities
 * @param <T> Target entity type
 */
public interface EntityMapper<T> {
    /**
     * Maps an array of values from a file to an entity
     * @param values Raw values from file 
     * @param columnMap Column name to index mapping
     * @return Mapped entity
     */
    T mapToEntity(String[] values, Map<String, Integer> columnMap);
}