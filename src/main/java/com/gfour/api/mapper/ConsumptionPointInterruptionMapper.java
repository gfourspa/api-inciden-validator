package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.ConsumptionPointInterruption;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad ConsumptionPointInterruption (INTERRUPCION_PUNTO_CONSUMO)
 */
@Component
public class ConsumptionPointInterruptionMapper implements EntityMapper<ConsumptionPointInterruption> {
    
    @Override
    public ConsumptionPointInterruption mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return ConsumptionPointInterruption.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .interrupcionId(MapperUtils.getValue(values, columnMap, "interrupcion_id"))
                .bloqueReposicionId(MapperUtils.getIntegerValue(values, columnMap, "bloque_reposicion_id"))
                .puntoConsumoId(MapperUtils.getValue(values, columnMap, "punto_consumo_id"))
                .fechaInicioInterrupcion(MapperUtils.getValue(values, columnMap, "fecha_inicio_interrupcion"))
                .fechaFinInterrupcion(MapperUtils.getValue(values, columnMap, "fecha_fin_interrupcion"))
                .energiaNoSuministrada(MapperUtils.getDoubleValue(values, columnMap, "energia_no_suministrada"))
                .build();
    }
}
