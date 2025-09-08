package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidenceSubstation;

/**
 * Repositorio para la entidad IncidenceSubstation (SUBESTACION_INCIDENCIA)
 */
@Repository
public interface IncidenceSubstationRepository extends JpaRepository<IncidenceSubstation, UUID> {
    
    /**
     * Busca subestaciones por incidencia
     */
    List<IncidenceSubstation> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca subestación específica por incidencia y subestación ID
     */
    Optional<IncidenceSubstation> findByIncidenciaIdAndSubestacionIncidenciaId(Integer incidenciaId, Integer subestacionIncidenciaId);
    
    /**
     * Busca por empresa y periodo
     */
    List<IncidenceSubstation> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por código de subestación
     */
    List<IncidenceSubstation> findBySubestacionCodigo(String subestacionCodigo);
    
    /**
     * Verifica si existe subestación para incidencia
     */
    @Query("SELECT COUNT(i) > 0 FROM IncidenceSubstation i WHERE i.incidenciaId = :incidenciaId")
    boolean existsByIncidenciaId(@Param("incidenciaId") Integer incidenciaId);
    
    /**
     * Busca por tipo de subestación
     */
    List<IncidenceSubstation> findByTipoSubestacionId(Integer tipoSubestacionId);
    
    /**
     * Busca por nivel de tensión
     */
    List<IncidenceSubstation> findByNivelTension(Integer nivelTension);
}
