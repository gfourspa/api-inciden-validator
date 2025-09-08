package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.FeederIncidence;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad FeederIncidence (ALIMENTADOR_INCIDENCIA)
 */
@Component
public class FeederIncidenceMapper implements EntityMapper<FeederIncidence> {

    @Override
    public FeederIncidence mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return FeederIncidence.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .alimentadorId(MapperUtils.getValue(values, columnMap, "alimentador_id"))
                .tipoAfectacionId(MapperUtils.getIntegerValue(values, columnMap, "tipo_afectacion_id"))
                .porcentajeAfectacion(MapperUtils.getDoubleValue(values, columnMap, "porcentaje_afectacion"))
                .numeroClientesAfectados(MapperUtils.getIntegerValue(values, columnMap, "numero_clientes_afectados"))
                .build();
    }
}
