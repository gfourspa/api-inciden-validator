package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.ConsumptionPointInterruption;

/**
 * Repositorio para la entidad ConsumptionPointInterruption (INTERRUPCION_PUNTO_CONSUMO)
 */
@Repository
public interface ConsumptionPointInterruptionRepository extends JpaRepository<ConsumptionPointInterruption, UUID> {
    
    /**
     * Busca interrupciones por incidencia
     */
    List<ConsumptionPointInterruption> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca interrupciones por interrupción ID
     */
    List<ConsumptionPointInterruption> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca interrupciones por bloque de reposición
     */
    List<ConsumptionPointInterruption> findByBloqueReposicionId(Integer bloqueReposicionId);
    
    /**
     * Busca interrupción específica
     */
    Optional<ConsumptionPointInterruption> findByIncidenciaIdAndInterrupcionIdAndBloqueReposicionIdAndPuntoConsumoId(
        Integer incidenciaId, String interrupcionId, Integer bloqueReposicionId, String puntoConsumoId);
    
    /**
     * Busca por empresa y periodo
     */
    List<ConsumptionPointInterruption> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por punto de consumo
     */
    List<ConsumptionPointInterruption> findByPuntoConsumoId(String puntoConsumoId);
    
    /**
     * Verifica si existe interrupción para punto de consumo
     */
    @Query("SELECT COUNT(c) > 0 FROM ConsumptionPointInterruption c WHERE c.incidenciaId = :incidenciaId AND c.puntoConsumoId = :puntoConsumoId")
    boolean existsByIncidenciaIdAndPuntoConsumoId(@Param("incidenciaId") Integer incidenciaId, @Param("puntoConsumoId") String puntoConsumoId);
    
    /**
     * Cuenta clientes interrumpidos por incidencia e interrupción
     */
    @Query("SELECT COUNT(c) FROM ConsumptionPointInterruption c WHERE c.incidenciaId = :incidenciaId AND c.interrupcionId = :interrupcionId")
    Long countByIncidenciaIdAndInterrupcionId(@Param("incidenciaId") Integer incidenciaId, @Param("interrupcionId") String interrupcionId);
}
