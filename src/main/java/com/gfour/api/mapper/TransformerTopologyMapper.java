package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.TransformerTopology;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad TransformerTopology (TRANSFORMADOR_TOPOLOGIA)
 */
@Component
public class TransformerTopologyMapper implements EntityMapper<TransformerTopology> {
    
    @Override
    public TransformerTopology mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return TransformerTopology.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .centralCodigo(MapperUtils.getValue(values, columnMap, "central_codigo"))
                .transformadorCodigo(MapperUtils.getValue(values, columnMap, "transformador_codigo"))
                .nivelTensionPrimario(MapperUtils.getIntegerValue(values, columnMap, "nivel_tension_primario"))
                .nivelTensionSecundario(MapperUtils.getIntegerValue(values, columnMap, "nivel_tension_secundario"))
                .participacionTransformador(MapperUtils.getDoubleValue(values, columnMap, "participacion_transformador"))
                .build();
    }
}
