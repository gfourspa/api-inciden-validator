package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.RestorationBlock;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad RestorationBlock (BLOQUE_REPOSICION)
 */
@Component
public class RestorationBlockMapper implements EntityMapper<RestorationBlock> {

    @Override
    public RestorationBlock mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return RestorationBlock.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .interrupcionId(MapperUtils.getValue(values, columnMap, "interrupcion_id"))
                .bloqueReposicionId(MapperUtils.getIntegerValue(values, columnMap, "bloque_reposicion_id"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .eventoRed(MapperUtils.getIntegerValue(values, columnMap, "evento_red"))
                .fechaInicioBloque(MapperUtils.getValue(values, columnMap, "fecha_inicio_bloque"))
                .fechaFinBloque(MapperUtils.getValue(values, columnMap, "fecha_fin_bloque"))
                .numeroClientesRepuestos(MapperUtils.getIntegerValue(values, columnMap, "numero_clientes_repuestos"))
                .energiaNoSuministrada(MapperUtils.getDoubleValue(values, columnMap, "energia_no_suministrada"))
                .build();
    }
}
