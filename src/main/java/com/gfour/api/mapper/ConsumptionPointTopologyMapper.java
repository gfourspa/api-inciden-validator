package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.ConsumptionPointTopology;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad ConsumptionPointTopology (PUNTO_CONSUMO_TOPOLOGIA)
 */
@Component
public class ConsumptionPointTopologyMapper implements EntityMapper<ConsumptionPointTopology> {
    
    @Override
    public ConsumptionPointTopology mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return ConsumptionPointTopology.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .puntoConsumoId(MapperUtils.getValue(values, columnMap, "punto_consumo_id"))
                .nodoIncidenciaId(MapperUtils.getIntegerValue(values, columnMap, "nodo_incidencia_id"))
                .puntoSuministroId(MapperUtils.getIntegerValue(values, columnMap, "punto_suministro_id"))
                .transformadorId(MapperUtils.getValue(values, columnMap, "transformador_id"))
                .demandaMaxima(MapperUtils.getDoubleValue(values, columnMap, "demanda_maxima"))
                .numeroClientes(MapperUtils.getIntegerValue(values, columnMap, "numero_clientes"))
                .build();
    }
}
