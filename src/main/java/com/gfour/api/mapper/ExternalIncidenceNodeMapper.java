package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.ExternalIncidenceNode;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad ExternalIncidenceNode (NODO_INCIDENCIA_EXTERNO)
 */
@Component
public class ExternalIncidenceNodeMapper implements EntityMapper<ExternalIncidenceNode> {
    
    @Override
    public ExternalIncidenceNode mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return ExternalIncidenceNode.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .nodoExternoId(MapperUtils.getValue(values, columnMap, "nodo_externo_id"))
                .tipoConexionExternaId(MapperUtils.getIntegerValue(values, columnMap, "tipo_conexion_externa"))
                .build();
    }
}
