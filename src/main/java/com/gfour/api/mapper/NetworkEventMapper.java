package com.gfour.api.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.NetworkEvent;
import com.gfour.api.utils.MapperUtils;

@Component
public class NetworkEventMapper implements EntityMapper<NetworkEvent> {

    @Override
    public NetworkEvent mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return NetworkEvent.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .eventId(MapperUtils.getString(values, columnMap, "event_id"))
                .eventTypeId(MapperUtils.getInteger(values, columnMap, "event_type_id"))
                .eventEffectId(MapperUtils.getInteger(values, columnMap, "event_effect_id"))
                .eventDate(parseDate(values, columnMap, "event_date", "yyyy-MM-dd HH:mm:ss"))
                .detectionType(MapperUtils.getString(values, columnMap, "detection_type"))
                .causeTypeId(MapperUtils.getInteger(values, columnMap, "cause_type_id"))
                .locationDescription(MapperUtils.getString(values, columnMap, "location_description"))
                .build();
    }

    private Date parseDate(String[] values, Map<String, Integer> columnMap, String columnName, String format) {
        String value = MapperUtils.getString(values, columnMap, columnName);
        if (value == null) return null;
        LocalDateTime ldt = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(format));
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
