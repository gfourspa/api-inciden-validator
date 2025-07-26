package com.gfour.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidentConsistency;


@Repository
public interface IncidentConsistencyRepository extends JpaRepository<IncidentConsistency, UUID> {
    
    List<IncidentConsistency> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<IncidentConsistency> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    List<IncidentConsistency> findByConsistencyType(String consistencyType);
    
    List<IncidentConsistency> findByIsConsistent(Boolean isConsistent);

    @Procedure(name = "spa_scs_valida_consistencia_EGA")
    void validateFeederConsistency();
}