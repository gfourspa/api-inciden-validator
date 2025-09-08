package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.ConsumptionPointTopology;

/**
 * Repositorio para la entidad ConsumptionPointTopology (PUNTO_CONSUMO_TOPOLOGIA)
 */
@Repository
public interface ConsumptionPointTopologyRepository extends JpaRepository<ConsumptionPointTopology, UUID> {
    
    /**
     * Busca topologías por incidencia
     */
    List<ConsumptionPointTopology> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca topología específica por incidencia y punto de consumo
     */
    Optional<ConsumptionPointTopology> findByIncidenciaIdAndPuntoConsumoId(Integer incidenciaId, String puntoConsumoId);
    
    /**
     * Busca por empresa y periodo
     */
    List<ConsumptionPointTopology> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por punto de consumo ID
     */
    List<ConsumptionPointTopology> findByPuntoConsumoId(String puntoConsumoId);
    
    /**
     * Busca por nodo de incidencia
     */
    List<ConsumptionPointTopology> findByNodoIncidenciaId(Integer nodoIncidenciaId);
    
    /**
     * Busca por punto de suministro
     */
    List<ConsumptionPointTopology> findByPuntoSuministroId(Integer puntoSuministroId);
    
    /**
     * Busca por transformador ID
     */
    List<ConsumptionPointTopology> findByTransformadorId(String transformadorId);
    
    /**
     * Verifica si existe topología para punto de consumo
     */
    @Query("SELECT COUNT(c) > 0 FROM ConsumptionPointTopology c WHERE c.incidenciaId = :incidenciaId AND c.puntoConsumoId = :puntoConsumoId")
    boolean existsByIncidenciaIdAndPuntoConsumoId(@Param("incidenciaId") Integer incidenciaId, @Param("puntoConsumoId") String puntoConsumoId);
}
