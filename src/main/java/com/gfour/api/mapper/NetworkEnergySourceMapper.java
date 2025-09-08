package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.NetworkEnergySource;
import com.gfour.api.utils.MapperUtils;


/**
 * Mapper para la entidad NetworkEnergySource (FUENTE_ENERGIA_RED)
 */
@Component
public class NetworkEnergySourceMapper implements EntityMapper<NetworkEnergySource> {

    @Override
    public NetworkEnergySource mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return NetworkEnergySource.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .fuenteEnergiaRedId(MapperUtils.getIntegerValue(values, columnMap, "fuente_energia_red_id"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .tipoFuenteId(MapperUtils.getIntegerValue(values, columnMap, "tipo_fuente_id"))
                .nodoIncidenciaId(MapperUtils.getIntegerValue(values, columnMap, "nodo_incidencia_id"))
                .build();
    }

    
}
