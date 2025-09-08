package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.AffectedFeederDetail;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad AffectedFeederDetail (ALIMENTADOR_AFECTADO)
 */
@Component
public class AffectedFeederDetailMapper implements EntityMapper<AffectedFeederDetail> {

    @Override
    public AffectedFeederDetail mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return AffectedFeederDetail.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .incidenciaId(MapperUtils.getIntegerValue(values, columnMap, "incidencia_id"))
                .alimentadorId(MapperUtils.getIntegerValue(values, columnMap, "alimentador_id"))
                .interrupcionId(MapperUtils.getValue(values, columnMap, "interrupcion_id"))
                .kvaInterrumpidosU(MapperUtils.getBigDecimalValue(values, columnMap, "kva_interrumpidos_u"))
                .kvaInterrumpidosR1(MapperUtils.getBigDecimalValue(values, columnMap, "kva_interrumpidos_r1"))
                .totalTranfoIntU(MapperUtils.getIntegerValue(values, columnMap, "total_tranfo_int_u"))
                .totalClientesInt(MapperUtils.getIntegerValue(values, columnMap, "total_clientes_int"))
                .totalTranfoIntR1(MapperUtils.getIntegerValue(values, columnMap, "total_tranfo_int_r1"))
                .kvaInterrumpidosR2(MapperUtils.getBigDecimalValue(values, columnMap, "kva_interrumpidos_r2"))
                .totalTranfoIntR2(MapperUtils.getIntegerValue(values, columnMap, "total_tranfo_int_r2"))
                .build();
    }
}
