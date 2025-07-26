package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidentNodeTableIntegrityError;


@Repository
public interface IncidentNodeTableIntegrityErrorRepository extends JpaRepository<IncidentNodeTableIntegrityError, UUID> {
    
    List<IncidentNodeTableIntegrityError> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<IncidentNodeTableIntegrityError> findByCompanyIdAndPeriodStarAndIncidentId(
            String companyId, String periodStar, Integer incidentId);
    
    List<IncidentNodeTableIntegrityError> findByNodeId(Integer nodeId);
    
    List<IncidentNodeTableIntegrityError> findByErrorDateBetween(Date startDate, Date endDate);
}