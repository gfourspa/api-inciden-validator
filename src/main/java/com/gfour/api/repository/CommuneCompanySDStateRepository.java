package com.gfour.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.CommuneCompanySDState;

/**
 * Repositorio para la entidad CommuneCompanySDState (ESTADO_COMUNA_EMPRESA_SD)
 */
@Repository
public interface CommuneCompanySDStateRepository extends JpaRepository<CommuneCompanySDState, UUID> {
    
    /**
     * Busca estados por empresa y periodo
     */
    @Query("SELECT c FROM CommuneCompanySDState c WHERE c.empresaId = :empresaId AND c.periodoStar = :periodoStar")
    List<CommuneCompanySDState> findByEmpresaIdAndPeriodoStar(@Param("empresaId") String empresaId, @Param("periodoStar") String periodoStar);
    
    /**
     * Busca estados por empresa, periodo y comuna
     */
    @Query("SELECT c FROM CommuneCompanySDState c WHERE c.empresaId = :empresaId AND c.periodoStar = :periodoStar AND c.comunaId = :comunaId")
    List<CommuneCompanySDState> findByEmpresaIdAndPeriodoStarAndComunaId(
        @Param("empresaId") String empresaId, 
        @Param("periodoStar") String periodoStar,
        @Param("comunaId") Integer comunaId);
    
    /**
     * Busca estados por interrupción
     */
    @Query("SELECT c FROM CommuneCompanySDState c WHERE c.interrupcionId = :interrupcionId")
    List<CommuneCompanySDState> findByInterrupcionId(@Param("interrupcionId") String interrupcionId);
    
    /**
     * Verifica si existe un estado para empresa, periodo y interrupción específicos
     */
    @Query("SELECT COUNT(c) > 0 FROM CommuneCompanySDState c WHERE c.empresaId = :empresaId AND c.periodoStar = :periodoStar AND c.interrupcionId = :interrupcionId")
    boolean existsByEmpresaIdAndPeriodoStarAndInterrupcionId(
        @Param("empresaId") String empresaId,
        @Param("periodoStar") String periodoStar,
        @Param("interrupcionId") String interrupcionId);
    
    /**
     * Busca estados por bloque de reposición
     */
    @Query("SELECT c FROM CommuneCompanySDState c WHERE c.bloqueReposicionId = :bloqueReposicionId")
    List<CommuneCompanySDState> findByBloqueReposicionId(@Param("bloqueReposicionId") Integer bloqueReposicionId);
    
    /**
     * Busca estados por tipo de interrupción
     */
    @Query("SELECT c FROM CommuneCompanySDState c WHERE c.tipoInterrupcionId = :tipoInterrupcionId")
    List<CommuneCompanySDState> findByTipoInterrupcionId(@Param("tipoInterrupcionId") Integer tipoInterrupcionId);
}
