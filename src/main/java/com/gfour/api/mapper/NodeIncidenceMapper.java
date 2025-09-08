package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.NodeIncidence;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad NodeIncidence (NODO_INCIDENCIA)
 */
@Component
public class NodeIncidenceMapper implements EntityMapper<NodeIncidence> {
    
    @Override
    public NodeIncidence mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return NodeIncidence.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .nodoCodigo(MapperUtils.getValue(values, columnMap, "nodo_codigo"))
                .duracionInterrupcion(MapperUtils.getIntegerValue(values, columnMap, "duracion_interrupcion"))
                .energiaNoSuministrada(MapperUtils.getDoubleValue(values, columnMap, "energia_no_suministrada"))
                .build();
    }
}
