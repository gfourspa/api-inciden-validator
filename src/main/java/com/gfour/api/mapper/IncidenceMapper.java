package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.Incidence;
import com.gfour.api.utils.MapperUtils;
/**
 * Mapper para la entidad Incidence (INCIDENCIA)
 */
@Component
public class IncidenceMapper implements EntityMapper<Incidence> {

    @Override
    public Incidence mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return Incidence.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .build();
    }
}
