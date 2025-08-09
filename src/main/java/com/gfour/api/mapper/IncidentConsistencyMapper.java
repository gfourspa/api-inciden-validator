package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.IncidentConsistency;
import com.gfour.api.utils.MapperUtils;

@Component
public class IncidentConsistencyMapper implements EntityMapper<IncidentConsistency> {

    @Override
    public IncidentConsistency mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return IncidentConsistency.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .incidentId(MapperUtils.getInteger(values, columnMap, "incident_id"))
                .consistencyType(MapperUtils.getString(values, columnMap, "consistency_type"))
                .isConsistent(MapperUtils.getBoolean(values, columnMap, "is_consistent"))
                .message(MapperUtils.getString(values, columnMap, "message"))
                .build();
    }
}
