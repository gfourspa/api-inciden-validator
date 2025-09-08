package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.RestorationBlock;

/**
 * Repositorio para la entidad RestorationBlock (BLOQUE_REPOSICION)
 */
@Repository
public interface RestorationBlockRepository extends JpaRepository<RestorationBlock, UUID> {
    
    /**
     * Busca bloques por incidencia
     */
    List<RestorationBlock> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca bloques por interrupción
     */
    List<RestorationBlock> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca bloque específico
     */
    Optional<RestorationBlock> findByIncidenciaIdAndInterrupcionIdAndBloqueReposicionId(
        Integer incidenciaId, String interrupcionId, Integer bloqueReposicionId);
    
    /**
     * Busca por empresa y periodo
     */
    List<RestorationBlock> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por evento de red
     */
    List<RestorationBlock> findByEventoRed(Integer eventoRed);
    
    /**
     * Verifica si existe bloque de reposición
     */
    @Query("SELECT COUNT(r) > 0 FROM RestorationBlock r WHERE r.incidenciaId = :incidenciaId AND r.interrupcionId = :interrupcionId AND r.bloqueReposicionId = :bloqueId")
    boolean existsByIncidenciaIdAndInterrupcionIdAndBloqueReposicionId(@Param("incidenciaId") Integer incidenciaId, 
                                                                       @Param("interrupcionId") String interrupcionId, 
                                                                       @Param("bloqueId") Integer bloqueId);
    
    /**
     * Busca bloques por ID de bloque
     */
    List<RestorationBlock> findByBloqueReposicionId(Integer bloqueReposicionId);
}
