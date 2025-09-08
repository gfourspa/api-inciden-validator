package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.IncidenceNodeConnection;

/**
 * Repositorio para la entidad IncidenceNodeConnection (CONEXION_NODO_INCIDENCIA)
 */
@Repository
public interface IncidenceNodeConnectionRepository extends JpaRepository<IncidenceNodeConnection, UUID> {
    
    /**
     * Busca conexiones por incidencia
     */
    List<IncidenceNodeConnection> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca conexiones que incluyan un nodo específico
     */
    @Query("SELECT c FROM IncidenceNodeConnection c WHERE c.incidenciaId = :incidenciaId AND (c.nodoIncidenciaId1 = :nodoId OR c.nodoIncidenciaId2 = :nodoId)")
    List<IncidenceNodeConnection> findByIncidenciaIdAndNodoIncidenciaId(@Param("incidenciaId") Integer incidenciaId, @Param("nodoId") Integer nodoId);
    
    /**
     * Busca por empresa y periodo
     */
    List<IncidenceNodeConnection> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca conexión específica entre dos nodos
     */
    Optional<IncidenceNodeConnection> findByIncidenciaIdAndNodoIncidenciaId1AndNodoIncidenciaId2(
        Integer incidenciaId, Integer nodoIncidenciaId1, Integer nodoIncidenciaId2);
    
    /**
     * Verifica si existe conexión entre nodos
     */
    @Query("SELECT COUNT(c) > 0 FROM IncidenceNodeConnection c WHERE c.incidenciaId = :incidenciaId AND ((c.nodoIncidenciaId1 = :nodo1 AND c.nodoIncidenciaId2 = :nodo2) OR (c.nodoIncidenciaId1 = :nodo2 AND c.nodoIncidenciaId2 = :nodo1))")
    boolean existsConnectionBetweenNodes(@Param("incidenciaId") Integer incidenciaId, @Param("nodo1") Integer nodo1, @Param("nodo2") Integer nodo2);
    
    /**
     * Busca por tipo de conexión
     */
    List<IncidenceNodeConnection> findByTipoConexionId(Integer tipoConexionId);
}
