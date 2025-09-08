package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.FeederIncidence;

/**
 * Repositorio para la entidad FeederIncidence (ALIMENTADOR_INCIDENCIA)
 */
@Repository
public interface FeederIncidenceRepository extends JpaRepository<FeederIncidence, UUID> {
    
    /**
     * Busca relación alimentador-incidencia por incidencia
     */
    List<FeederIncidence> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca relación por incidencia y alimentador
     */
    Optional<FeederIncidence> findByIncidenciaIdAndAlimentadorId(Integer incidenciaId, String alimentadorId);
    
    /**
     * Busca por empresa y periodo
     */
    List<FeederIncidence> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por alimentador ID
     */
    List<FeederIncidence> findByAlimentadorId(String alimentadorId);
    
    /**
     * Verifica si existe la relación
     */
    @Query("SELECT COUNT(f) > 0 FROM FeederIncidence f WHERE f.incidenciaId = :incidenciaId AND f.alimentadorId = :alimentadorId")
    boolean existsByIncidenciaIdAndAlimentadorId(@Param("incidenciaId") Integer incidenciaId, @Param("alimentadorId") String alimentadorId);
    
    /**
     * Busca por tipo de afectación
     */
    List<FeederIncidence> findByTipoAfectacionId(Integer tipoAfectacionId);
}
