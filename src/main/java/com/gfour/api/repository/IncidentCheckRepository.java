package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidentCheck;


@Repository
public interface IncidentCheckRepository extends JpaRepository<IncidentCheck, UUID> {
    
    List<IncidentCheck> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<IncidentCheck> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    List<IncidentCheck> findByCheckDateBetween(Date startDate, Date endDate);
    
    List<IncidentCheck> findByCheckType(String checkType);
    
    List<IncidentCheck> findByCheckResult(Boolean checkResult);
}