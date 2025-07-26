package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidentFeeder;

@Repository
public interface IncidentFeederRepository extends JpaRepository<IncidentFeeder, UUID> {
    
    List<IncidentFeeder> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<IncidentFeeder> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    Optional<IncidentFeeder> findByCompanyIdAndPeriodStarAndIncidentIdAndFeederId(
            String companyId, String periodStar, Integer incidentId, Integer feederId);
}