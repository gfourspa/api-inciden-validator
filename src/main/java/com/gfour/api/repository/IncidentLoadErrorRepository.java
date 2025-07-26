package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidentLoadError;


@Repository
public interface IncidentLoadErrorRepository extends JpaRepository<IncidentLoadError, UUID> {
    
    List<IncidentLoadError> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<IncidentLoadError> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    List<IncidentLoadError> findByErrorDateBetween(Date startDate, Date endDate);
    
    List<IncidentLoadError> findByErrorCode(String errorCode);
}