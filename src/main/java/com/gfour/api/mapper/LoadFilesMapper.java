package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.LoadFiles;
import com.gfour.api.utils.MapperUtils;

@Component
public class LoadFilesMapper implements EntityMapper<LoadFiles> {

    @Override
    public LoadFiles mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return LoadFiles.builder()
                .status(MapperUtils.getString(values, columnMap, "status"))
                .build();
    }
}
