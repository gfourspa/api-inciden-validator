package com.gfour.api.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.IncidentTableError;
import com.gfour.api.utils.MapperUtils;

@Component
public class IncidentTableErrorMapper implements EntityMapper<IncidentTableError> {

    @Override
    public IncidentTableError mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return IncidentTableError.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .incidentId(MapperUtils.getInteger(values, columnMap, "incident_id"))
                .tableName(MapperUtils.getString(values, columnMap, "table_name"))
                .errorDate(parseDate(values, columnMap, "error_date", "yyyy-MM-dd HH:mm:ss"))
                .errorDescription(MapperUtils.getString(values, columnMap, "error_description"))
                .build();
    }

    private Date parseDate(String[] values, Map<String, Integer> columnMap, String columnName, String format) {
        String value = MapperUtils.getString(values, columnMap, columnName);
        if (value == null) return null;
        LocalDateTime ldt = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(format));
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
