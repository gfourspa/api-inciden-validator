package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.TransformerTopology;

/**
 * Repositorio para la entidad TransformerTopology (TRANSFORMADOR_TOPOLOGIA)
 */
@Repository
public interface TransformerTopologyRepository extends JpaRepository<TransformerTopology, UUID> {
    
    /**
     * Busca topologías por empresa y periodo
     */
    List<TransformerTopology> findByEmpresaIdAndPeriodoStar(String empresaId, String periodoStar);
    
    /**
     * Busca topología específica por central y transformador
     */
    Optional<TransformerTopology> findByCentralCodigoAndTransformadorCodigo(String centralCodigo, String transformadorCodigo);
    
    /**
     * Busca por código de transformador
     */
    List<TransformerTopology> findByTransformadorCodigo(String transformadorCodigo);
    
    /**
     * Busca por código de central
     */
    List<TransformerTopology> findByCentralCodigo(String centralCodigo);
    
    /**
     * Verifica si existe topología para transformador
     */
    @Query("SELECT COUNT(t) > 0 FROM TransformerTopology t WHERE t.transformadorCodigo = :transformadorCodigo")
    boolean existsByTransformadorCodigo(@Param("transformadorCodigo") String transformadorCodigo);
    
    /**
     * Busca por nivel de tensión primario
     */
    List<TransformerTopology> findByNivelTensionPrimario(Integer nivelTensionPrimario);
    
    /**
     * Busca por nivel de tensión secundario
     */
    List<TransformerTopology> findByNivelTensionSecundario(Integer nivelTensionSecundario);
    
    /**
     * Busca por zona
     */
    List<TransformerTopology> findByZonaCodigo(String zonaCodigo);
}
