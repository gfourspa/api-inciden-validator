package com.gfour.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.AffectedFeeder;


@Repository
public interface AffectedFeederRepository extends JpaRepository<AffectedFeeder, UUID> {
    
    List<AffectedFeeder> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<AffectedFeeder> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    List<AffectedFeeder> findByInterruptionId(String interruptionId);
}