package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidenceSupplyPoint;

/**
 * Repositorio para la entidad IncidenceSupplyPoint (PUNTO_SUMINISTRO_INCIDENCIA)
 */
@Repository
public interface IncidenceSupplyPointRepository extends JpaRepository<IncidenceSupplyPoint, UUID> {
    
    /**
     * Busca puntos de suministro por incidencia
     */
    List<IncidenceSupplyPoint> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca punto específico por incidencia y punto de suministro
     */
    Optional<IncidenceSupplyPoint> findByIncidenciaIdAndPuntoSuministroId(Integer incidenciaId, Integer puntoSuministroId);
    
    /**
     * Busca por empresa y periodo
     */
    List<IncidenceSupplyPoint> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por punto de suministro ID
     */
    List<IncidenceSupplyPoint> findByPuntoSuministroId(Integer puntoSuministroId);
    
    /**
     * Verifica si existe punto de suministro para incidencia
     */
    @Query("SELECT COUNT(i) > 0 FROM IncidenceSupplyPoint i WHERE i.incidenciaId = :incidenciaId")
    boolean existsByIncidenciaId(@Param("incidenciaId") Integer incidenciaId);
    
    /**
     * Busca por tipo de suministro
     */
    List<IncidenceSupplyPoint> findByTipoSuministroId(Integer tipoSuministroId);
    
    /**
     * Busca por estado de suministro
     */
    List<IncidenceSupplyPoint> findByEstadoSuministroId(Integer estadoSuministroId);
}
