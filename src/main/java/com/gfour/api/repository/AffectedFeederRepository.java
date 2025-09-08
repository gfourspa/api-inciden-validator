package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.AffectedFeeder;

/**
 * Repositorio para la entidad AffectedFeeder (ALIMENTADOR_AFECTADO)
 */
@Repository
public interface AffectedFeederRepository extends JpaRepository<AffectedFeeder, UUID> {
    
    /**
     * Busca alimentadores afectados por incidencia
     */
    List<AffectedFeeder> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca alimentadores afectados por interrupción
     */
    List<AffectedFeeder> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca alimentadores afectados por empresa y periodo
     */
    List<AffectedFeeder> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca alimentador afectado específico
     */
    Optional<AffectedFeeder> findByIncidenciaIdAndInterrupcionIdAndAlimentadorId(Integer incidenciaId, String interrupcionId, String alimentadorId);
    
    /**
     * Verifica si existe alimentador afectado
     */
    @Query("SELECT COUNT(a) > 0 FROM AffectedFeeder a WHERE a.incidenciaId = :incidenciaId AND a.alimentadorId = :alimentadorId")
    boolean existsByIncidenciaIdAndAlimentadorId(@Param("incidenciaId") Integer incidenciaId, @Param("alimentadorId") String alimentadorId);
    
    /**
     * Busca alimentadores afectados por alimentador ID
     */
    List<AffectedFeeder> findByAlimentadorId(String alimentadorId);
}
