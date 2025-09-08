package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidenceDerivationPoint;

/**
 * Repositorio para la entidad IncidenceDerivationPoint (PUNTO_DERIVACION_INCIDENCIA)
 */
@Repository
public interface IncidenceDerivationPointRepository extends JpaRepository<IncidenceDerivationPoint, UUID> {
    
    /**
     * Busca puntos de derivación por incidencia
     */
    List<IncidenceDerivationPoint> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca punto específico por incidencia y punto de derivación
     */
    Optional<IncidenceDerivationPoint> findByIncidenciaIdAndPuntoDerivacionIncidenciaId(Integer incidenciaId, Integer puntoDerivacionIncidenciaId);
    
    /**
     * Busca por empresa y periodo
     */
    List<IncidenceDerivationPoint> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por nodo de incidencia
     */
    List<IncidenceDerivationPoint> findByNodoIncidenciaId(Integer nodoIncidenciaId);
    
    /**
     * Verifica si existe punto de derivación para incidencia
     */
    @Query("SELECT COUNT(i) > 0 FROM IncidenceDerivationPoint i WHERE i.incidenciaId = :incidenciaId")
    boolean existsByIncidenciaId(@Param("incidenciaId") Integer incidenciaId);
    
    /**
     * Busca por tipo de derivación
     */
    List<IncidenceDerivationPoint> findByTipoDerivacionId(Integer tipoDerivacionId);
}
