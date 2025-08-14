package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.AffectedFeeder;
import com.gfour.api.utils.MapperUtils;

@Component
public class AffectedFeederMapper implements EntityMapper<AffectedFeeder> {
    
    @Override
    public AffectedFeeder mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return AffectedFeeder.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .incidentId(MapperUtils.getInteger(values, columnMap, "incident_id"))
                .feederId(MapperUtils.getInteger(values, columnMap, "feeder_id"))
                .interruptionId(MapperUtils.getString(values, columnMap, "interruption_id"))
                .interruptedKvaU(MapperUtils.getDouble(values, columnMap, "interrupted_kva_u"))
                .interruptedKvaR1(MapperUtils.getDouble(values, columnMap, "interrupted_kva_r1"))
                .totalTransfoIntU(MapperUtils.getInteger(values, columnMap, "total_transfo_int_u"))
                .totalInterruptedClients(MapperUtils.getInteger(values, columnMap, "total_interrupted_clients"))
                .totalTransfoIntR1(MapperUtils.getInteger(values, columnMap, "total_transfo_int_r1"))
                .interruptedKvaR2(MapperUtils.getDouble(values, columnMap, "interrupted_kva_r2"))
                .totalTransfoIntR2(MapperUtils.getInteger(values, columnMap, "total_transfo_int_r2"))
                .build();
    }
}