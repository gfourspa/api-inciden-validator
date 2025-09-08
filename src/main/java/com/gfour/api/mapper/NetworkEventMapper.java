package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.NetworkEvent;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad NetworkEvent (EVENTO_RED)
 */
@Component
public class NetworkEventMapper implements EntityMapper<NetworkEvent> {

    @Override
    public NetworkEvent mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return NetworkEvent.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .eventoredId(MapperUtils.getIntegerValue(values, columnMap, "eventored_id"))
                .nodoIncidenciaId(MapperUtils.getIntegerValue(values, columnMap, "nodo_incidencia_id"))
                .tipoEventoId(MapperUtils.getIntegerValue(values, columnMap, "tipo_evento_id"))
                .fechaEvento(MapperUtils.getValue(values, columnMap, "fecha_evento"))
                .build();
    }
}
