package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.TransformerInterruption;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad TransformerInterruption (TRANSFORMADOR_INTERRUPCION)
 */
@Component
public class TransformerInterruptionMapper implements EntityMapper<TransformerInterruption> {
    
    @Override
    public TransformerInterruption mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return TransformerInterruption.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .transformadorId(MapperUtils.getValue(values, columnMap, "transformador_id"))
                .interrupcionId(MapperUtils.getValue(values, columnMap, "interrupcion_id"))
                .bloqueReposicionId(MapperUtils.getIntegerValue(values, columnMap, "bloque_reposicion_id"))
                .fechaInicioInterrupcion(MapperUtils.getValue(values, columnMap, "fecha_inicio_interrupcion"))
                .fechaFinInterrupcion(MapperUtils.getValue(values, columnMap, "fecha_fin_interrupcion"))
                .build();
    }
}
