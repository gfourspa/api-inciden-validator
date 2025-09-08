package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.Bridge;

/**
 * Repositorio para la entidad Bridge (PUENTE)
 */
@Repository
public interface BridgeRepository extends JpaRepository<Bridge, UUID> {
    
    /**
     * Busca puentes por incidencia
     */
    List<Bridge> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca puente específico por incidencia y puente ID
     */
    Optional<Bridge> findByIncidenciaIdAndPuenteId(Integer incidenciaId, String puenteId);
    
    /**
     * Busca por empresa y periodo
     */
    List<Bridge> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por puente ID
     */
    List<Bridge> findByPuenteId(String puenteId);
    
    /**
     * Busca por nodo de incidencia
     */
    List<Bridge> findByNodoIncidenciaId(Integer nodoIncidenciaId);
    
    /**
     * Verifica si existe puente para incidencia
     */
    @Query("SELECT COUNT(b) > 0 FROM Bridge b WHERE b.incidenciaId = :incidenciaId")
    boolean existsByIncidenciaId(@Param("incidenciaId") Integer incidenciaId);
    
    /**
     * Busca por tipo de puente
     */
    List<Bridge> findByTipoPuenteId(Integer tipoPuenteId);
    
    /**
     * Busca por estado de puente
     */
    List<Bridge> findByEstadoPuenteId(Integer estadoPuenteId);
}
