package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.EventDescription;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad EventDescription (DESCRIPCION_EVENTO)
 */
@Component
public class EventDescriptionMapper implements EntityMapper<EventDescription> {

    @Override
    public EventDescription mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return EventDescription.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .eventoredId(MapperUtils.getIntegerValue(values, columnMap, "eventored_id"))
                .descripcionEvento(MapperUtils.getValue(values, columnMap, "descripcion_evento"))
                .build();
    }
}
