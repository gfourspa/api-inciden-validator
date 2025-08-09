package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.Notification;
import com.gfour.api.utils.MapperUtils;

@Component
public class NotificationMapper implements EntityMapper<Notification> {

    @Override
    public Notification mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return Notification.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .interruptionId(MapperUtils.getString(values, columnMap, "interruption_id"))
                .notificationId(MapperUtils.getInteger(values, columnMap, "notification_id"))
                .notificationTypeId(MapperUtils.getInteger(values, columnMap, "notification_type_id"))
                .supplyPointId(MapperUtils.getString(values, columnMap, "supply_point_id"))
                .notificationDescription(MapperUtils.getString(values, columnMap, "notification_description"))
                .presentationId(MapperUtils.getString(values, columnMap, "presentation_id"))
                .build();
    }
}
