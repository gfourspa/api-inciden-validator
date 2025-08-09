package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.EventDescription;
import com.gfour.api.utils.MapperUtils;

@Component
public class EventDescriptionMapper implements EntityMapper<EventDescription> {

    @Override
    public EventDescription mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return EventDescription.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .eventId(MapperUtils.getString(values, columnMap, "event_id"))
                .description(MapperUtils.getString(values, columnMap, "description"))
                .build();
    }
}
