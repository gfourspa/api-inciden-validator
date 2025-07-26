package com.gfour.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.ReplacementBlock;


@Repository
public interface ReplacementBlockRepository extends JpaRepository<ReplacementBlock, UUID> {
    
    List<ReplacementBlock> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<ReplacementBlock> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    List<ReplacementBlock> findByInterruptionId(String interruptionId);
    
    List<ReplacementBlock> findByReplacementType(String replacementType);
}