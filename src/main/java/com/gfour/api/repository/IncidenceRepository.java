package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.Incidence;

/**
 * Repositorio para la entidad Incidence (INCIDENCIA)
 */
@Repository
public interface IncidenceRepository extends JpaRepository<Incidence, UUID> {
    
    /**
     * Busca incidencia por ID de incidencia
     */
    Optional<Incidence> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca incidencias por empresa y periodo
     */
    List<Incidence> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca incidencias por tipo
     */
    List<Incidence> findByTipoIncidenciaId(Integer tipoIncidenciaId);
    
    /**
     * Verifica si existe una incidencia con el ID dado
     */
    @Query("SELECT COUNT(i) > 0 FROM Incidence i WHERE i.incidenciaId = :incidenciaId")
    boolean existsByIncidenciaId(@Param("incidenciaId") Integer incidenciaId);
    
    /**
     * Busca incidencias por estado
     */
    List<Incidence> findByEstadoIncidenciaId(Integer estadoIncidenciaId);
}
