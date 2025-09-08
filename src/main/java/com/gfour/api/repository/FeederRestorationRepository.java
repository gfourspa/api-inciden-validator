package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.FeederRestoration;

/**
 * Repositorio para la entidad FeederRestoration (ALIMENTADOR_REPOSICION)
 */
@Repository
public interface FeederRestorationRepository extends JpaRepository<FeederRestoration, UUID> {
    
    /**
     * Busca reposiciones por incidencia
     */
    List<FeederRestoration> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca reposiciones por interrupción
     */
    List<FeederRestoration> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca reposiciones por bloque
     */
    List<FeederRestoration> findByBloqueReposicionId(Integer bloqueReposicionId);
    
    /**
     * Busca reposición específica
     */
    Optional<FeederRestoration> findByIncidenciaIdAndInterrupcionIdAndBloqueReposicionIdAndAlimentadorId(
        Integer incidenciaId, String interrupcionId, Integer bloqueReposicionId, String alimentadorId);
    
    /**
     * Busca por empresa y periodo
     */
    List<FeederRestoration> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Verifica si existe reposición para alimentador
     */
    @Query("SELECT COUNT(f) > 0 FROM FeederRestoration f WHERE f.incidenciaId = :incidenciaId AND f.alimentadorId = :alimentadorId")
    boolean existsByIncidenciaIdAndAlimentadorId(@Param("incidenciaId") Integer incidenciaId, @Param("alimentadorId") String alimentadorId);
    
    /**
     * Busca por alimentador ID
     */
    List<FeederRestoration> findByAlimentadorId(String alimentadorId);
}
