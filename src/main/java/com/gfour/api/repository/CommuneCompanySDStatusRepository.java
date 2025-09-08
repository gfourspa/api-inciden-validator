package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.CommuneCompanySDStatus;

/**
 * Repositorio para la entidad CommuneCompanySDStatus (ESTADO_COMUNA_EMPRESA_SD)
 */
@Repository
public interface CommuneCompanySDStatusRepository extends JpaRepository<CommuneCompanySDStatus, UUID> {
    
    /**
     * Busca estados por interrupción
     */
    List<CommuneCompanySDStatus> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca estados por empresa y periodo
     */
    List<CommuneCompanySDStatus> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca por bloque de reposición
     */
    List<CommuneCompanySDStatus> findByBloqueReposicionId(Integer bloqueReposicionId);
    
    /**
     * Busca por comuna
     */
    List<CommuneCompanySDStatus> findByComunaCodigo(String comunaCodigo);
    
    /**
     * Busca estado específico por interrupción y bloque
     */
    Optional<CommuneCompanySDStatus> findByInterrupcionIdAndBloqueReposicionId(String interrupcionId, Integer bloqueReposicionId);
    
    /**
     * Verifica si existe estado para interrupción
     */
    @Query("SELECT COUNT(c) > 0 FROM CommuneCompanySDStatus c WHERE c.interrupcionId = :interrupcionId")
    boolean existsByInterrupcionId(@Param("interrupcionId") String interrupcionId);
    
    /**
     * Busca por tipo de interrupción
     */
    List<CommuneCompanySDStatus> findByTipoInterrupcionId(Integer tipoInterrupcionId);
    
    /**
     * Suma clientes sin suministro por interrupción
     */
    @Query("SELECT COALESCE(SUM(c.clientesSinSuministro), 0) FROM CommuneCompanySDStatus c WHERE c.interrupcionId = :interrupcionId")
    Long sumClientesSinSuministroByInterrupcionId(@Param("interrupcionId") String interrupcionId);
}
