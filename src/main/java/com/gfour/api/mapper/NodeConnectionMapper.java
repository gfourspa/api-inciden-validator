package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.NodeConnection;
import com.gfour.api.utils.MapperUtils;

@Component
public class NodeConnectionMapper implements EntityMapper<NodeConnection> {

    @Override
    public NodeConnection mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return NodeConnection.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .incidentId(MapperUtils.getInteger(values, columnMap, "incident_id"))
                .nodeId(MapperUtils.getInteger(values, columnMap, "node_id"))
                .adjacentNodeId(MapperUtils.getInteger(values, columnMap, "adjacent_node_id"))
                .connectionTypeId(MapperUtils.getInteger(values, columnMap, "connection_type_id"))
                .build();
    }
}
