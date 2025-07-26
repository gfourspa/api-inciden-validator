package com.gfour.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.ReplacementFeeder;


@Repository
public interface ReplacementFeederRepository extends JpaRepository<ReplacementFeeder, UUID> {
    
    List<ReplacementFeeder> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<ReplacementFeeder> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    List<ReplacementFeeder> findByInterruptionId(String interruptionId);
    
    List<ReplacementFeeder> findByReplacementBlockId(Integer replacementBlockId);
}