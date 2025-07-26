package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.EventDescription;


@Repository
public interface EventDescriptionRepository extends JpaRepository<EventDescription, UUID> {
    
    List<EventDescription> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    Optional<EventDescription> findByCompanyIdAndPeriodStarAndEventId(String companyId, String periodStar, String eventId);
}