package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidentTableError;


@Repository
public interface IncidentTableErrorRepository extends JpaRepository<IncidentTableError, UUID> {
    
    List<IncidentTableError> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<IncidentTableError> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    List<IncidentTableError> findByTableName(String tableName);
    
    List<IncidentTableError> findByErrorDateBetween(Date startDate, Date endDate);

    @Procedure(name = "spa_scs_Valida_Incidencias_Tablas_EGA")
    void validateIncidenceTables();
}