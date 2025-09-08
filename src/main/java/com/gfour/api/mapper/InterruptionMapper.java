package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.Interruption;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad Interruption (INTERRUPCION)
 */
@Component
public class InterruptionMapper implements EntityMapper<Interruption> {

    @Override
    public Interruption mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return Interruption.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .interrupcionId(MapperUtils.getValue(values, columnMap, "interrupcion_id"))
                .calificacionInterrupcionId(MapperUtils.getIntegerValue(values, columnMap, "calificacion_interrupcion_id"))
                .origenInterrupcionId(MapperUtils.getIntegerValue(values, columnMap, "origen_interrupcion_id"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .fechaInicioInterrupcion(MapperUtils.getValue(values, columnMap, "fh_inicio_interrupcion"))
                .build();
    }
}
