package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.NetworkEnergySource;
import com.gfour.api.utils.MapperUtils;

@Component
public class NetworkEnergySourceMapper implements EntityMapper<NetworkEnergySource> {

    @Override
    public NetworkEnergySource mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return NetworkEnergySource.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .energySourceId(MapperUtils.getInteger(values, columnMap, "energy_source_id"))
                .energySourceTypeId(MapperUtils.getInteger(values, columnMap, "energy_source_type_id"))
                .sourceName(MapperUtils.getString(values, columnMap, "source_name"))
                .description(MapperUtils.getString(values, columnMap, "description"))
                .coordinatesX(parseDouble(values, columnMap, "coordinates_x"))
                .coordinatesY(parseDouble(values, columnMap, "coordinates_y"))
                .build();
    }

    private Double parseDouble(String[] values, Map<String, Integer> columnMap, String columnName) {
        String v = MapperUtils.getString(values, columnMap, columnName);
        return v == null ? null : Double.parseDouble(v.replace(",", "."));
    }
}
