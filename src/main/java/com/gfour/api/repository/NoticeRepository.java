package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.Notice;

/**
 * Repositorio para la entidad Notice (AVISO)
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice, UUID> {
    
    /**
     * Busca avisos por ID de aviso
     */
    Optional<Notice> findByAvisoId(String avisoId);
    
    /**
     * Busca avisos por interrupción
     */
    List<Notice> findByInterrupcionId(String interrupcionId);
    
    /**
     * Busca avisos por empresa y periodo
     */
    List<Notice> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca avisos por tipo
     */
    List<Notice> findByTipoAvisoId(Integer tipoAvisoId);
    
    /**
     * Verifica si existe aviso para interrupción
     */
    @Query("SELECT COUNT(n) > 0 FROM Notice n WHERE n.interrupcionId = :interrupcionId")
    boolean existsByInterrupcionId(@Param("interrupcionId") String interrupcionId);
    
    /**
     * Busca avisos por medio de aviso
     */
    List<Notice> findByMedioAvisoId(Integer medioAvisoId);
}
