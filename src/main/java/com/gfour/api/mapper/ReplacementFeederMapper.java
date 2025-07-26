package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.ReplacementFeeder;
import com.gfour.api.utils.MapperUtils;

@Component
public class ReplacementFeederMapper implements EntityMapper<ReplacementFeeder> {
    
    @Override
    public ReplacementFeeder mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return ReplacementFeeder.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .incidentId(MapperUtils.getInteger(values, columnMap, "incident_id"))
                .feederId(MapperUtils.getInteger(values, columnMap, "feeder_id"))
                .interruptionId(MapperUtils.getString(values, columnMap, "interruption_id"))
                .replacementBlockId(MapperUtils.getInteger(values, columnMap, "replacement_block_id"))
                .replacedKvaR1(MapperUtils.getBigDecimal(values, columnMap, "replaced_kva_r1"))
                .replacedKvaU(MapperUtils.getBigDecimal(values, columnMap, "replaced_kva_u"))
                .replacedKvaR2(MapperUtils.getBigDecimal(values, columnMap, "replaced_kva_r2"))
                .build();
    }
}