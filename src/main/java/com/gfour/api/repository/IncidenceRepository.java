package com.gfour.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.Incidence;

@Repository
public interface IncidenceRepository extends JpaRepository<Incidence, UUID> {

    @Query(value = "SELECT COUNT(*) FROM INCIDENCIA", nativeQuery = true)
    Long countAllIncidences();
    
    List<Incidence> findByCompanyId(String companyId);
    
    @Procedure(name = "spa_scs_Limpia_Tablas_EGA")
    void cleanTables();
    
}
