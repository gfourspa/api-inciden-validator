package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.NetworkEvent;

/**
 * Repositorio para la entidad NetworkEvent (EVENTO_RED)
 */
@Repository
public interface NetworkEventRepository extends JpaRepository<NetworkEvent, UUID> {
    
    /**
     * Busca eventos de red por ID de incidencia
     */
    List<NetworkEvent> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca eventos de red por empresa y periodo
     */
    List<NetworkEvent> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca evento de red por incidencia y evento ID
     */
    Optional<NetworkEvent> findByIncidenciaIdAndEventoredId(Integer incidenciaId, Integer eventoredId);
    
    /**
     * Verifica si existe un evento de red con los parámetros dados
     */
    @Query("SELECT COUNT(e) > 0 FROM NetworkEvent e WHERE e.incidenciaId = :incidenciaId AND e.eventoredId = :eventoredId")
    boolean existsByIncidenciaIdAndEventoredId(@Param("incidenciaId") Integer incidenciaId, @Param("eventoredId") Integer eventoredId);
}
