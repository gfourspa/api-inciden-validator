package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.TableIntegrityValidationError;


@Repository
public interface TableIntegrityValidationErrorRepository extends JpaRepository<TableIntegrityValidationError, UUID> {
    
    List<TableIntegrityValidationError> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<TableIntegrityValidationError> findByTableName(String tableName);
    
    List<TableIntegrityValidationError> findByErrorDateBetween(Date startDate, Date endDate);
    
    List<TableIntegrityValidationError> findByValidationType(String validationType);
}