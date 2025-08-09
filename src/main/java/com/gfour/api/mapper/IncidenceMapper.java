package com.gfour.api.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.Incidence;
import com.gfour.api.utils.MapperUtils;

@Component
public class IncidenceMapper implements EntityMapper<Incidence> {

    @Override
    public Incidence mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return Incidence.builder()
                .incidenceId(MapperUtils.getString(values, columnMap, "incidence_id"))
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .period(MapperUtils.getString(values, columnMap, "period"))
                .customerReference(MapperUtils.getString(values, columnMap, "customer_reference"))
                .startDate(parseLdt(values, columnMap, "start_date", "yyyy-MM-dd HH:mm:ss"))
                .endDate(parseLdt(values, columnMap, "end_date", "yyyy-MM-dd HH:mm:ss"))
                .build();
    }

    private LocalDateTime parseLdt(String[] values, Map<String, Integer> columnMap, String columnName, String format) {
        String v = MapperUtils.getString(values, columnMap, columnName);
        return v == null ? null : LocalDateTime.parse(v, DateTimeFormatter.ofPattern(format));
    }
}
