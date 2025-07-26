package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.NetworkEvent;


@Repository
public interface NetworkEventRepository extends JpaRepository<NetworkEvent, UUID> {
    
    List<NetworkEvent> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    Optional<NetworkEvent> findByEventId(String eventId);
    
    List<NetworkEvent> findByEventTypeId(Integer eventTypeId);
    
    List<NetworkEvent> findByEventEffectId(Integer eventEffectId);
    
    List<NetworkEvent> findByEventDateBetween(Date startDate, Date endDate);
    
    List<NetworkEvent> findByDetectionType(String detectionType);
    
    List<NetworkEvent> findByCauseTypeId(Integer causeTypeId);
}