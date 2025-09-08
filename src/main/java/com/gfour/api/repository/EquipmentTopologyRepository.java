package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.EquipmentTopology;

/**
 * Repositorio para la entidad EquipmentTopology (EQUIPO_TOPOLOGIA)
 */
@Repository
public interface EquipmentTopologyRepository extends JpaRepository<EquipmentTopology, UUID> {
    
    /**
     * Busca topologías por incidencia
     */
    List<EquipmentTopology> findByIncidenciaId(Integer incidenciaId);
    
    /**
     * Busca topología específica por incidencia y equipo
     */
    Optional<EquipmentTopology> findByIncidenciaIdAndEquipoId(Integer incidenciaId, String equipoId);
    
    /**
     * Busca por empresa y periodo
     */
    List<EquipmentTopology> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por equipo ID
     */
    List<EquipmentTopology> findByEquipoId(String equipoId);
    
    /**
     * Verifica si existe topología para equipo
     */
    @Query("SELECT COUNT(e) > 0 FROM EquipmentTopology e WHERE e.incidenciaId = :incidenciaId AND e.equipoId = :equipoId")
    boolean existsByIncidenciaIdAndEquipoId(@Param("incidenciaId") Integer incidenciaId, @Param("equipoId") String equipoId);
    
    /**
     * Busca por estado de equipo
     */
    List<EquipmentTopology> findByEstadoEquipoId(Integer estadoEquipoId);
    
    /**
     * Busca equipos conectados a un nodo específico
     */
    @Query("SELECT e FROM EquipmentTopology e WHERE e.nodoOrigenId = :nodoId OR e.nodoDestinoId = :nodoId")
    List<EquipmentTopology> findByNodoOrigenIdOrNodoDestinoId(@Param("nodoId") String nodoId);
}
