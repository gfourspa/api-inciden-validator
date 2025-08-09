package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.Datum;
import com.gfour.api.utils.MapperUtils;

@Component
public class DatumMapper implements EntityMapper<Datum> {

    @Override
    public Datum mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return Datum.builder()
                .typeId(MapperUtils.getInteger(values, columnMap, "type_id"))
                .tableName(MapperUtils.getString(values, columnMap, "table_name"))
                .columnName(MapperUtils.getString(values, columnMap, "column_name"))
                .code(MapperUtils.getString(values, columnMap, "code"))
                .description(MapperUtils.getString(values, columnMap, "description"))
                .build();
    }
}
