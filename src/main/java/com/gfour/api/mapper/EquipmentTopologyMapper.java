package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.EquipmentTopology;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad EquipmentTopology (EQUIPO_TOPOLOGIA)
 */
@Component
public class EquipmentTopologyMapper implements EntityMapper<EquipmentTopology> {

    @Override
    public EquipmentTopology mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return EquipmentTopology.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .equipoId(MapperUtils.getValue(values, columnMap, "equipo_id"))
                .nodoOrigenId(MapperUtils.getValue(values, columnMap, "nodo_origen_id"))
                .nodoDestinoId(MapperUtils.getValue(values, columnMap, "nodo_destino_id"))
                .estadoEquipoId(MapperUtils.getIntegerValue(values, columnMap, "estado_equipo_id"))
                .impedanciaEquipo(MapperUtils.getDoubleValue(values, columnMap, "impedancia_equipo"))
                .build();
    }
}
