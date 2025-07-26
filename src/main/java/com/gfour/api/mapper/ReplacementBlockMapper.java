package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.ReplacementBlock;
import com.gfour.api.utils.MapperUtils;

@Component
public class ReplacementBlockMapper implements EntityMapper<ReplacementBlock> {
    
    @Override
    public ReplacementBlock mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return ReplacementBlock.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .incidentId(MapperUtils.getInteger(values, columnMap, "incident_id"))
                .interruptionId(MapperUtils.getString(values, columnMap, "interruption_id"))
                .replacementBlockId(MapperUtils.getInteger(values, columnMap, "replacement_block_id"))
                .replacementDatetime(MapperUtils.getLocalDateTime(values, columnMap, "replacement_datetime", "yyyy-MM-dd HH:mm:ss"))
                .replacementType(MapperUtils.getString(values, columnMap, "replacement_type"))
                .replacedClients(MapperUtils.getInteger(values, columnMap, "replaced_clients"))
                .build();
    }
}