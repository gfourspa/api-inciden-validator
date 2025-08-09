package com.gfour.api.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.IncidentCheck;
import com.gfour.api.utils.MapperUtils;

@Component
public class IncidentCheckMapper implements EntityMapper<IncidentCheck> {

    @Override
    public IncidentCheck mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return IncidentCheck.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .incidentId(MapperUtils.getInteger(values, columnMap, "incident_id"))
                .checkDate(parseDate(values, columnMap, "check_date", "yyyy-MM-dd HH:mm:ss"))
                .checkType(MapperUtils.getString(values, columnMap, "check_type"))
                .checkResult(MapperUtils.getBoolean(values, columnMap, "check_result"))
                .description(MapperUtils.getString(values, columnMap, "description"))
                .build();
    }

    private Date parseDate(String[] values, Map<String, Integer> columnMap, String columnName, String format) {
        String value = MapperUtils.getString(values, columnMap, columnName);
        if (value == null) return null;
        LocalDateTime ldt = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(format));
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
