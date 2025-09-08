package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.NodeIncidence;

/**
 * Repositorio para la entidad NodeIncidence (NODO_INCIDENCIA)
 */
@Repository
public interface NodeIncidenceRepository extends JpaRepository<NodeIncidence, UUID> {
    
    /**
     * Busca nodos por incidencia
     */
    List<NodeIncidence> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca nodo específico por incidencia y nodo
     */
    Optional<NodeIncidence> findByIncidenciaIdAndNodoCodigo(Integer incidenciaId, String nodoCodigo);
    
    /**
     * Busca por empresa y periodo
     */
    List<NodeIncidence> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por código de nodo
     */
    List<NodeIncidence> findByNodoCodigo(String nodoCodigo);
    
    /**
     * Verifica si existe nodo de incidencia
     */
    @Query("SELECT COUNT(n) > 0 FROM NodeIncidence n WHERE n.incidenciaId = :incidenciaId AND n.nodoCodigo = :nodoCodigo")
    boolean existsByIncidenciaIdAndNodoCodigo(@Param("incidenciaId") Integer incidenciaId, @Param("nodoCodigo") String nodoCodigo);
    
    /**
     * Busca nodos con duración de interrupción mayor a un valor
     */
    @Query("SELECT n FROM NodeIncidence n WHERE n.duracionInterrupcion > :duracionMinima")
    List<NodeIncidence> findByDuracionInterrupcionGreaterThan(@Param("duracionMinima") Integer duracionMinima);
}
