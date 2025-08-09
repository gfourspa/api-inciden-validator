package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.TopologyEquipment;
import com.gfour.api.utils.MapperUtils;

@Component
public class TopologyEquipmentMapper implements EntityMapper<TopologyEquipment> {

    @Override
    public TopologyEquipment mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return TopologyEquipment.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .equipmentId(MapperUtils.getString(values, columnMap, "equipment_id"))
                .equipmentTypeId(MapperUtils.getInteger(values, columnMap, "equipment_type_id"))
                .equipmentName(MapperUtils.getString(values, columnMap, "equipment_name"))
                .normalizingStatus(MapperUtils.getString(values, columnMap, "normalizing_status"))
                .operationalStatus(MapperUtils.getString(values, columnMap, "operational_status"))
                .build();
    }
}
