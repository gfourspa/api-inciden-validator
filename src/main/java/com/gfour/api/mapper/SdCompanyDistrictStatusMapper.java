package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.SdCompanyDistrictStatus;
import com.gfour.api.utils.MapperUtils;

@Component
public class SdCompanyDistrictStatusMapper implements EntityMapper<SdCompanyDistrictStatus> {

    @Override
    public SdCompanyDistrictStatus mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return SdCompanyDistrictStatus.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .districtId(MapperUtils.getString(values, columnMap, "district_id"))
                .sdType(MapperUtils.getString(values, columnMap, "sd_type"))
                .status(MapperUtils.getString(values, columnMap, "status"))
                .description(MapperUtils.getString(values, columnMap, "description"))
                .build();
    }
}
