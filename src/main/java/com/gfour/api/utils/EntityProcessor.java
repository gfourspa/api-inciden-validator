package com.gfour.api.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EntityProcessor<T> {
        protected List<T> entities = new ArrayList<>();
        protected Map<String, Integer> columnMap = new HashMap<>();
    
        
        /**
         * Initialize column mapping from header line
         * @param headers Array of column headers
         */
        public void initializeColumnMap(String[] headers) {
            for (int i = 0; i < headers.length; i++) {
                columnMap.put(headers[i].trim().toLowerCase(), i);
            }
        }
        
        /**
         * Process a single line from the file
         * @param line The line to process
         */
        public void processLine(String line) {
            String[] values = line.split(Constants.DELIMITER, -1);
            T entity = mapToEntity(values);
            entities.add(entity);
        }
        
        /**
         * Map an array of values to an entity
         * @param values The values to map
         * @return Mapped entity
         */
        protected abstract T mapToEntity(String[] values);
        
        /**
         * Save all processed entities
         */
        public abstract void saveEntities();
        
    }