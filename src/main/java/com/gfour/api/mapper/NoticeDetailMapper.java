package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.NoticeDetail;
import com.gfour.api.utils.MapperUtils;

/**
 * Mapper para la entidad NoticeDetail (AVISO)
 */
@Component
public class NoticeDetailMapper implements EntityMapper<NoticeDetail> {

    @Override
    public NoticeDetail mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return NoticeDetail.builder()
                .empresaId(MapperUtils.getValue(values, columnMap, "empresa_id"))
                .periodoStar(MapperUtils.getValue(values, columnMap, "periodo_star"))
                .interrupcionId(MapperUtils.getValue(values, columnMap, "interrupcion_id"))
                .avisoId(MapperUtils.getIntegerValue(values, columnMap, "aviso_id"))
                .tipoAvisoId(MapperUtils.getIntegerValue(values, columnMap, "tipo_aviso_id"))
                .puntoSuministroId(MapperUtils.getValue(values, columnMap, "punto_suministro_id"))
                .descripcionAviso(MapperUtils.getValue(values, columnMap, "descripcion_aviso"))
                .presentacionId(MapperUtils.getValue(values, columnMap, "presentacion_id"))
                .build();
    }

}
