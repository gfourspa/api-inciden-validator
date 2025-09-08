package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.IncidenceNodeConnection;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad IncidenceNodeConnection (CONEXION_NODO_INCIDENCIA)
 */
@Component
public class IncidenceNodeConnectionMapper implements EntityMapper<IncidenceNodeConnection> {

    @Override
    public IncidenceNodeConnection mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return IncidenceNodeConnection.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .nodoIncidenciaId1(MapperUtils.getIntegerValue(values, columnMap, "nodo_incidencia_id_1"))
                .nodoIncidenciaId2(MapperUtils.getIntegerValue(values, columnMap, "nodo_incidencia_id_2"))
                .build();
    }
}
