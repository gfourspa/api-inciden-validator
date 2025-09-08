package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.Bridge;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad Bridge (PUENTE)
 */
@Component
public class BridgeMapper implements EntityMapper<Bridge> {
    
    @Override
    public Bridge mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return Bridge.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .puenteId(MapperUtils.getValue(values, columnMap, "puente_id"))
                .estadoPuenteId(MapperUtils.getIntegerValue(values, columnMap, "estado_puente_id"))
                .tipoPuenteId(MapperUtils.getIntegerValue(values, columnMap, "tipo_puente_id"))
                .capacidadPuente(MapperUtils.getDoubleValue(values, columnMap, "capacidad_puente"))
                .build();
    }
}
