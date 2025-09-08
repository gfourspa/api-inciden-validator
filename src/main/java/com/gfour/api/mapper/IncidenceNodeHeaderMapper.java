package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.IncidenceNodeHeader;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad IncidenceNodeHeader (NODO_INCIDENCIA_CABECERA)
 */
@Component
public class IncidenceNodeHeaderMapper implements EntityMapper<IncidenceNodeHeader> {
    
    @Override
    public IncidenceNodeHeader mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return IncidenceNodeHeader.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .esCabecera(MapperUtils.getBooleanValue(values, columnMap, "es_cabecera"))
                .build();
    }
}
