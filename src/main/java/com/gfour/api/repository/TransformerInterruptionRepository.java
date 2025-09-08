package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.TransformerInterruption;

/**
 * Repositorio para la entidad TransformerInterruption (TRANSFORMADOR_INTERRUPCION)
 */
@Repository
public interface TransformerInterruptionRepository extends JpaRepository<TransformerInterruption, UUID> {
    
    /**
     * Busca interrupciones por incidencia
     */
    List<TransformerInterruption> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca interrupciones por interrupción ID
     */
    List<TransformerInterruption> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca interrupciones por bloque de reposición
     */
    List<TransformerInterruption> findByBloqueReposicionId(Integer bloqueReposicionId);
    
    /**
     * Busca interrupción específica
     */
    Optional<TransformerInterruption> findByIncidenciaIdAndInterrupcionIdAndBloqueReposicionIdAndTransformadorId(
        Integer incidenciaId, String interrupcionId, Integer bloqueReposicionId, String transformadorId);
    
    /**
     * Busca por empresa y periodo
     */
    List<TransformerInterruption> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por transformador ID
     */
    List<TransformerInterruption> findByTransformadorId(String transformadorId);
    
    /**
     * Verifica si existe interrupción para transformador
     */
    @Query("SELECT COUNT(t) > 0 FROM TransformerInterruption t WHERE t.incidenciaId = :incidenciaId AND t.transformadorId = :transformadorId")
    boolean existsByIncidenciaIdAndTransformadorId(@Param("incidenciaId") Integer incidenciaId, @Param("transformadorId") String transformadorId);
    
    /**
     * Suma potencia interrumpida por incidencia e interrupción
     */
    @Query("SELECT COALESCE(SUM(t.potenciaInterrumpida), 0) FROM TransformerInterruption t WHERE t.incidenciaId = :incidenciaId AND t.interrupcionId = :interrupcionId")
    Double sumPotenciaInterrumpidaByIncidenciaIdAndInterrupcionId(@Param("incidenciaId") Integer incidenciaId, @Param("interrupcionId") String interrupcionId);
}
