package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.FeederRestorationDetail;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad FeederRestorationDetail (ALIMENTADOR_REPOSICION)
 */
@Component
public class FeederRestorationDetailMapper implements EntityMapper<FeederRestorationDetail> {

    @Override
    public FeederRestorationDetail mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return FeederRestorationDetail.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .alimentadorId(MapperUtils.getIntegerValue(values, columnMap, "alimentador_id"))
                .interrupcionId(MapperUtils.getValue(values, columnMap, "interrupcion_id"))
                .bloqueReposicionId(MapperUtils.getIntegerValue(values, columnMap, "bloque_reposicion_id"))
                .kvaRepuestosR1(MapperUtils.getBigDecimalValue(values, columnMap, "kva_repuestos_r1"))
                .kvaRepuestosU(MapperUtils.getBigDecimalValue(values, columnMap, "kva_repuestos_u"))
                .kvaRepuestosR2(MapperUtils.getBigDecimalValue(values, columnMap, "kva_repuestos_r2"))
                .build();
    }
   
}
