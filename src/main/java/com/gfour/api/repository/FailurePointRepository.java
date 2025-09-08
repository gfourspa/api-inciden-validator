package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.FailurePoint;

/**
 * Repositorio para la entidad FailurePoint (PUNTO_FALLA)
 */
@Repository
public interface FailurePointRepository extends JpaRepository<FailurePoint, UUID> {
    
    /**
     * Busca puntos de falla por incidencia
     */
    List<FailurePoint> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca punto de falla específico por incidencia y punto de falla
     */
    Optional<FailurePoint> findByIncidenciaIdAndPuntoFallaId(Integer incidenciaId, String puntoFallaId);
    
    /**
     * Busca puntos de falla por interrupción
     */
    List<FailurePoint> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca por empresa y periodo
     */
    List<FailurePoint> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por equipo fallado
     */
    List<FailurePoint> findByEquipoFalladoId(String equipoFalladoId);
    
    /**
     * Busca por distrito
     */
    List<FailurePoint> findByDistritoCodigo(String distritoCodigo);
    
    /**
     * Verifica si existe punto de falla para incidencia
     */
    @Query("SELECT COUNT(f) > 0 FROM FailurePoint f WHERE f.incidenciaId = :incidenciaId")
    boolean existsByIncidenciaId(@Param("incidenciaId") Integer incidenciaId);
    
    /**
     * Busca puntos de falla en un área geográfica
     */
    @Query("SELECT f FROM FailurePoint f WHERE f.coordenadaNorte BETWEEN :minNorte AND :maxNorte AND f.coordenadaEste BETWEEN :minEste AND :maxEste")
    List<FailurePoint> findByCoordinatesRange(@Param("minNorte") Double minNorte, @Param("maxNorte") Double maxNorte, 
                                             @Param("minEste") Double minEste, @Param("maxEste") Double maxEste);
}
