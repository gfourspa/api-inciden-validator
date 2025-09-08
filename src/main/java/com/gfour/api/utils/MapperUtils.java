package com.gfour.api.utils;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Utility methods for mapping file data to entities
 */
public class MapperUtils {

    private MapperUtils() {
        // Private constructor to prevent instantiation
    }

    public static String getValue(String[] values, Map<String, Integer> columnMap, String columnName) {
        Integer index = columnMap.get(columnName);
        return (index != null && index < values.length && !values[index].trim().isEmpty()) 
            ? values[index].trim() : null;
    }

    public static Integer getIntegerValue(String[] values, Map<String, Integer> columnMap, String columnName) {
        String value = getValue(values, columnMap, columnName);
        return (value != null) ? Integer.valueOf(value) : null;
    }

    public static Long getLongValue(String[] values, Map<String, Integer> columnMap, String columnName) {
        String value = getValue(values, columnMap, columnName);
        return (value != null) ? Long.valueOf(value) : null;
    }

    public static Double getDoubleValue(String[] values, Map<String, Integer> columnMap, String columnName) {
        String value = getValue(values, columnMap, columnName);
        return (value != null) ? Double.valueOf(value) : null;
    }

    public static BigDecimal getBigDecimalValue(String[] values, Map<String, Integer> columnMap, String columnName) {
        String value = getValue(values, columnMap, columnName);
        return (value != null) ? new BigDecimal(value) : null;
    }

    public static Boolean getBooleanValue(String[] values, Map<String, Integer> columnMap, String columnName) {
        String value = getValue(values, columnMap, columnName);
        if (value == null) {
            return Boolean.FALSE;
        }
        
        String lowerValue = value.toLowerCase();
        return "true".equals(lowerValue) || "1".equals(lowerValue) || "s".equals(lowerValue) || 
               "si".equals(lowerValue) || "y".equals(lowerValue) || "yes".equals(lowerValue);
    }

}
    