package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.Interruption;

/**
 * Repositorio para la entidad Interruption (INTERRUPCION)
 */
@Repository
public interface InterruptionRepository extends JpaRepository<Interruption, UUID> {
    
    /**
     * Busca interrupción por ID de interrupción
     */
    Optional<Interruption> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca interrupciones por incidencia
     */
    List<Interruption> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca interrupciones por empresa y periodo
     */
    List<Interruption> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca interrupciones por incidencia e interrupción ID
     */
    Optional<Interruption> findByIncidenciaIdAndInterrupcionId(Integer incidenciaId, String interrupcionId);
    
    /**
     * Verifica si existe una interrupción con tipo origen específico
     */
    @Query("SELECT COUNT(i) > 0 FROM Interruption i WHERE i.incidenciaId = :incidenciaId AND i.interrupcionId = :interrupcionId AND i.origenInterrupcionId = :tipoOrigen")
    boolean existsByIncidenciaIdAndInterrupcionIdAndTipoOrigen(@Param("incidenciaId") Integer incidenciaId, 
                                                              @Param("interrupcionId") String interrupcionId, 
                                                              @Param("tipoOrigen") Integer tipoOrigen);
    
    /**
     * Busca interrupciones por tipo de origen
     */
    List<Interruption> findByOrigenInterrupcionId(Integer origenInterrupcionId);
}
