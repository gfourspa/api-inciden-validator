package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.EventDescription;

/**
 * Repositorio para la entidad EventDescription (DESCRIPCION_EVENTO)
 */
@Repository
public interface EventDescriptionRepository extends JpaRepository<EventDescription, UUID> {
    
    /**
     * Busca descripciones por incidencia
     */
    List<EventDescription> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca descripción específica por incidencia y evento
     */
    Optional<EventDescription> findByIncidenciaIdAndEventoredId(Integer incidenciaId, Integer eventoredId);
    
    /**
     * Busca por empresa y periodo
     */
    List<EventDescription> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por ID de evento
     */
    List<EventDescription> findByEventoredId(Integer eventoredId);
    
    /**
     * Verifica si existe descripción para evento
     */
    @Query("SELECT COUNT(e) > 0 FROM EventDescription e WHERE e.incidenciaId = :incidenciaId AND e.eventoredId = :eventoredId")
    boolean existsByIncidenciaIdAndEventoredId(@Param("incidenciaId") Integer incidenciaId, @Param("eventoredId") Integer eventoredId);
    
    /**
     * Busca por categoría de evento
     */
    List<EventDescription> findByCategoriaEventoId(Integer categoriaEventoId);
    
    /**
     * Busca por severidad de evento
     */
    List<EventDescription> findBySeveridadEventoId(Integer severidadEventoId);
}
