package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.InterruptionTableError;


@Repository
public interface InterruptionTableErrorRepository extends JpaRepository<InterruptionTableError, UUID> {
    
    List<InterruptionTableError> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<InterruptionTableError> findByInterruptionId(String interruptionId);
    
    List<InterruptionTableError> findByTableName(String tableName);
    
    List<InterruptionTableError> findByErrorDateBetween(Date startDate, Date endDate);
}