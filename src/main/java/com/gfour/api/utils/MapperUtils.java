package com.gfour.api.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

/**
 * Utility methods for mapping file data to entities
 */
public class MapperUtils {

    private MapperUtils() {
        // Private constructor to prevent instantiation
    }
    
    /**
     * Get a string value from the values array
     * @param values The values array
     * @param columnMap The column map
     * @param columnName The column name
     * @return The string value
     */
    public static String getString(String[] values, Map<String, Integer> columnMap, String columnName) {
        Integer index = columnMap.get(columnName.toLowerCase());
        if (index == null || index >= values.length) {
            return null;
        }
        String value = values[index].trim();
        return value.isEmpty() ? null : value;
    }
    
    /**
     * Get an integer value from the values array
     * @param values The values array
     * @param columnMap The column map
     * @param columnName The column name
     * @return The integer value
     */
    public static Integer getInteger(String[] values, Map<String, Integer> columnMap, String columnName) {
        String value = getString(values, columnMap, columnName);
        return value == null ? null : Integer.parseInt(value);
    }
    
    /**
     * Get a boolean value from the values array
     * @param values The values array
     * @param columnMap The column map
     * @param columnName The column name
     * @return The boolean value
     */
    public static Boolean getBoolean(String[] values, Map<String, Integer> columnMap, String columnName) {
        String value = getString(values, columnMap, columnName);
        if (value == null) return null;
        return "1".equals(value) || "true".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value);
    }
    
    /**
     * Get a big decimal value from the values array
     * @param values The values array
     * @param columnMap The column map
     * @param columnName The column name
     * @return The big decimal value
     */
    public static BigDecimal getBigDecimal(String[] values, Map<String, Integer> columnMap, String columnName) {
        String value = getString(values, columnMap, columnName);
        return value == null ? null : new BigDecimal(value.replace(",", "."));
    }
    
    /**
     * Get a LocalDateTime value from the values array
     * @param values The values array
     * @param columnMap The column map
     * @param columnName The column name
     * @param format The date format
     * @return The LocalDateTime value
     */
    public static LocalDateTime getLocalDateTime(String[] values, Map<String, Integer> columnMap, String columnName, String format) {
        String value = getString(values, columnMap, columnName);
        if (value == null) return null;
        try {
            return LocalDateTime.parse(value, DateTimeFormatter.ofPattern(format));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format for column " + columnName + ": " + value);
        }
    }
}