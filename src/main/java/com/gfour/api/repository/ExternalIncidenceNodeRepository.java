package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.ExternalIncidenceNode;

/**
 * Repositorio para la entidad ExternalIncidenceNode (NODO_INCIDENCIA_EXTERNO)
 */
@Repository
public interface ExternalIncidenceNodeRepository extends JpaRepository<ExternalIncidenceNode, UUID> {
    
    /**
     * Busca nodos externos por incidencia
     */
    List<ExternalIncidenceNode> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca nodo externo específico por incidencia y nodo
     */
    Optional<ExternalIncidenceNode> findByIncidenciaIdAndNodoIncidenciaId(Integer incidenciaId, Integer nodoIncidenciaId);
    
    /**
     * Busca por empresa y periodo
     */
    List<ExternalIncidenceNode> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por empresa externa
     */
    List<ExternalIncidenceNode> findByEmpresaExternaId(String empresaExternaId);
    
    /**
     * Busca por nodo externo ID
     */
    List<ExternalIncidenceNode> findByNodoExternoId(String nodoExternoId);
    
    /**
     * Verifica si existe nodo externo para incidencia
     */
    @Query("SELECT COUNT(e) > 0 FROM ExternalIncidenceNode e WHERE e.incidenciaId = :incidenciaId AND e.nodoIncidenciaId = :nodoIncidenciaId")
    boolean existsByIncidenciaIdAndNodoIncidenciaId(@Param("incidenciaId") Integer incidenciaId, @Param("nodoIncidenciaId") Integer nodoIncidenciaId);
    
    /**
     * Busca por tipo de conexión externa
     */
    List<ExternalIncidenceNode> findByTipoConexionExternaId(Integer tipoConexionExternaId);
}
