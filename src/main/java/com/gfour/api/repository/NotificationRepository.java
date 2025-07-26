package com.gfour.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.Notification;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    
    List<Notification> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<Notification> findByInterruptionId(String interruptionId);
    
    List<Notification> findByNotificationTypeId(Integer notificationTypeId);
    
    List<Notification> findBySupplyPointId(String supplyPointId);
}