package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.Connectivity;
import com.gfour.api.utils.MapperUtils;

@Component
public class ConnectivityMapper implements EntityMapper<Connectivity> {

    @Override
    public Connectivity mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return Connectivity.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .nodeId(MapperUtils.getInteger(values, columnMap, "node_id"))
                .adjacentNodeId(MapperUtils.getInteger(values, columnMap, "adjacent_node_id"))
                .connectionTypeId(MapperUtils.getInteger(values, columnMap, "connection_type_id"))
                .normalized(MapperUtils.getBoolean(values, columnMap, "normalized"))
                .build();
    }
}
