package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidenceNodeHeader;

/**
 * Repositorio para la entidad IncidenceNodeHeader (NODO_INCIDENCIA_CABECERA)
 */
@Repository
public interface IncidenceNodeHeaderRepository extends JpaRepository<IncidenceNodeHeader, UUID> {
    
    /**
     * Busca cabeceras por incidencia
     */
    List<IncidenceNodeHeader> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca cabecera específica por incidencia y nodo
     */
    Optional<IncidenceNodeHeader> findByIncidenciaIdAndNodoIncidenciaId(Integer incidenciaId, Integer nodoIncidenciaId);
    
    /**
     * Busca por empresa y periodo
     */
    List<IncidenceNodeHeader> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca nodos que son cabecera
     */
    List<IncidenceNodeHeader> findByEsCabecera(Boolean esCabecera);
    
    /**
     * Verifica si existe cabecera para nodo de incidencia
     */
    @Query("SELECT COUNT(i) > 0 FROM IncidenceNodeHeader i WHERE i.incidenciaId = :incidenciaId AND i.nodoIncidenciaId = :nodoIncidenciaId")
    boolean existsByIncidenciaIdAndNodoIncidenciaId(@Param("incidenciaId") Integer incidenciaId, @Param("nodoIncidenciaId") Integer nodoIncidenciaId);
    
    /**
     * Busca cabeceras ordenadas por orden
     */
    @Query("SELECT i FROM IncidenceNodeHeader i WHERE i.incidenciaId = :incidenciaId ORDER BY i.ordenCabecera")
    List<IncidenceNodeHeader> findByIncidenciaIdOrderByOrdenCabecera(@Param("incidenciaId") Integer incidenciaId);
}
