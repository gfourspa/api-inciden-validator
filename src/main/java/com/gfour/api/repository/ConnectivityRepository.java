package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.Connectivity;


@Repository
public interface ConnectivityRepository extends JpaRepository<Connectivity, UUID> {
    
    List<Connectivity> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<Connectivity> findByNodeId(Integer nodeId);
    
    List<Connectivity> findByAdjacentNodeId(Integer adjacentNodeId);
    
    Optional<Connectivity> findByNodeIdAndAdjacentNodeId(Integer nodeId, Integer adjacentNodeId);
    
    List<Connectivity> findByConnectionTypeId(Integer connectionTypeId);
    
    List<Connectivity> findByNormalized(Boolean normalized);

    @Procedure(name = "spa_scs_Valida_Tablas_Interrupciones_EGA")
    void validateInterruptionTables();
}