package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.NetworkEnergySource;

/**
 * Repositorio para la entidad NetworkEnergySource (FUENTE_ENERGIA_RED)
 */
@Repository
public interface NetworkEnergySourceRepository extends JpaRepository<NetworkEnergySource, UUID> {
    
    /**
     * Busca fuentes por incidencia
     */
    List<NetworkEnergySource> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca fuente específica por incidencia y fuente ID
     */
    Optional<NetworkEnergySource> findByIncidenciaIdAndFuenteEnergiaRedId(Integer incidenciaId, Integer fuenteEnergiaRedId);
    
    /**
     * Busca por empresa y periodo
     */
    List<NetworkEnergySource> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por nodo de incidencia
     */
    List<NetworkEnergySource> findByNodoIncidenciaId(Integer nodoIncidenciaId);
    
    /**
     * Verifica si existe fuente de energía
     */
    @Query("SELECT COUNT(n) > 0 FROM NetworkEnergySource n WHERE n.incidenciaId = :incidenciaId AND n.nodoIncidenciaId = :nodoIncidenciaId")
    boolean existsByIncidenciaIdAndNodoIncidenciaId(@Param("incidenciaId") Integer incidenciaId, @Param("nodoIncidenciaId") Integer nodoIncidenciaId);
    
    /**
     * Busca por tipo de fuente
     */
    List<NetworkEnergySource> findByTipoFuenteId(Integer tipoFuenteId);
    
    /**
     * Busca fuentes con potencia disponible mayor a un valor
     */
    @Query("SELECT n FROM NetworkEnergySource n WHERE n.potenciaDisponible > :potenciaMinima")
    List<NetworkEnergySource> findByPotenciaDisponibleGreaterThan(@Param("potenciaMinima") Double potenciaMinima);
}
