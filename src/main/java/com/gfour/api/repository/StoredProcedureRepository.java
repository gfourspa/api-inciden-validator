package com.gfour.api.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gfour.api.entity.Audit;

/**
 * Repositorio especial para ejecutar los 4 stored procedures de validación
 * - spa_scs_valida_carga: Validación de carga e integridad referencial
 * - spa_scs_valida_consistencia: Validación de consistencia de datos
 * - spa_scs_valida_incidencias_tablas: Validación de integridad de incidencias
 * - spa_scs_valida_tablas_interrup: Validación de tablas de interrupciones
 */
@Repository
public interface StoredProcedureRepository extends JpaRepository<Audit, String> {
    
    /**
     * Ejecuta el stored procedure spa_scs_valida_carga
     * Valida la carga de datos e integridad referencial entre tablas
     * 
     * @return Lista de mapas con los resultados del reporte de carga
     */
    @Query(value = "CALL spa_scs_valida_carga()", nativeQuery = true)
    @Transactional
    @Modifying
    List<Map<String, Object>> ejecutarValidacionCarga();
    
    /**
     * Ejecuta el stored procedure spa_scs_valida_consistencia
     * Valida la consistencia de datos entre diferentes tablas
     * 
     * @return Lista de mapas con las inconsistencias encontradas
     */
    @Query(value = "CALL spa_scs_valida_consistencia()", nativeQuery = true)
    @Transactional
    @Modifying
    List<Map<String, Object>> ejecutarValidacionConsistencia();
    
    /**
     * Ejecuta el stored procedure spa_scs_valida_incidencias_tablas
     * Valida la integridad entre la tabla de incidencias y sus tablas relacionadas
     * 
     * @return Lista de mapas con los errores de integridad de incidencias
     */
    @Query(value = "CALL spa_scs_valida_incidencias_tablas()", nativeQuery = true)
    @Transactional
    @Modifying
    List<Map<String, Object>> ejecutarValidacionIncidenciasTablas();
    
    /**
     * Ejecuta el stored procedure spa_scs_valida_tablas_interrup
     * Valida la integridad entre las tablas de interrupciones
     * 
     * @return Lista de mapas con los errores de integridad de interrupciones
     */
    @Query(value = "CALL spa_scs_valida_tablas_interrup()", nativeQuery = true)
    @Transactional
    @Modifying
    List<Map<String, Object>> ejecutarValidacionTablasInterrupcion();
    
    // ============================================================================
    // MÉTODOS AUXILIARES PARA CONSULTAR RESULTADOS DE VALIDACIONES
    // ============================================================================
    
    /**
     * Obtiene el reporte de carga de incidencias
     * 
     * @return Lista con el reporte de carga por archivo
     */
    @Query(value = "SELECT * FROM REP_CARGA_INC ORDER BY archivo", nativeQuery = true)
    List<Map<String, Object>> obtenerReporteCarga();
    
    /**
     * Obtiene los errores de carga de incidencias
     * 
     * @return Lista con los errores de carga encontrados
     */
    @Query(value = "SELECT * FROM ERR_CARGA_INC ORDER BY TABLA, ID", nativeQuery = true)
    List<Map<String, Object>> obtenerErroresCarga();
    
    /**
     * Obtiene los errores de carga por tabla específica
     * 
     * @param tabla Nombre de la tabla a consultar
     * @return Lista con los errores de carga de la tabla especificada
     */
    @Query(value = "SELECT * FROM ERR_CARGA_INC WHERE TABLA = :tabla ORDER BY ID", nativeQuery = true)
    List<Map<String, Object>> obtenerErroresCargaPorTabla(@Param("tabla") String tabla);
    
    /**
     * Obtiene las inconsistencias encontradas
     * 
     * @return Lista con las inconsistencias de datos
     */
    @Query(value = "SELECT * FROM CONSISTENCIA_INCIDENCIA ORDER BY incidencia_id", nativeQuery = true)
    List<Map<String, Object>> obtenerInconsistencias();
    
    /**
     * Obtiene las inconsistencias por incidencia específica
     * 
     * @param incidenciaId ID de la incidencia a consultar
     * @return Lista con las inconsistencias de la incidencia especificada
     */
    @Query(value = "SELECT * FROM CONSISTENCIA_INCIDENCIA WHERE incidencia_id = :incidenciaId", nativeQuery = true)
    List<Map<String, Object>> obtenerInconsistenciasPorIncidencia(@Param("incidenciaId") Integer incidenciaId);
    
    /**
     * Obtiene los errores de integridad de incidencias
     * 
     * @return Lista con los errores de integridad de incidencias
     */
    @Query(value = "SELECT * FROM ERR_INCIDENCIA_TABLAS ORDER BY Incidencia_Hija", nativeQuery = true)
    List<Map<String, Object>> obtenerErroresIncidenciasTablas();
    
    /**
     * Obtiene los errores de integridad de tablas de interrupción
     * 
     * @return Lista con los errores de integridad de interrupciones
     */
    @Query(value = "SELECT * FROM ERR_TABLAS_INTERRUPCION ORDER BY empresa_id, periodo_star, Incidencia_Padre", nativeQuery = true)
    List<Map<String, Object>> obtenerErroresTablasInterrupcion();
    
    /**
     * Obtiene los errores de interrupciones por empresa y periodo
     * 
     * @param empresaId ID de la empresa
     * @param periodoStar Periodo a consultar
     * @return Lista con los errores de interrupciones filtrados
     */
    @Query(value = "SELECT * FROM ERR_TABLAS_INTERRUPCION WHERE empresa_id = :empresaId AND periodo_star = :periodoStar ORDER BY Incidencia_Padre", nativeQuery = true)
    List<Map<String, Object>> obtenerErroresTablasInterrupcionPorEmpresaYPeriodo(
        @Param("empresaId") String empresaId, 
        @Param("periodoStar") String periodoStar);
    
    /**
     * Obtiene el log de errores del sistema
     * 
     * @return Lista con el historial de errores del sistema
     */
    @Query(value = "SELECT * FROM LOG_ERRORES ORDER BY fecha DESC", nativeQuery = true)
    List<Map<String, Object>> obtenerLogErrores();
    
    /**
     * Obtiene estadísticas de validación por tabla
     * 
     * @return Lista con estadísticas de enviados vs cargados por tabla
     */
    @Query(value = "SELECT archivo, enviados, cargados, diferencia, duracion FROM REP_CARGA_INC WHERE enviados > 0 ORDER BY archivo", nativeQuery = true)
    List<Map<String, Object>> obtenerEstadisticasValidacion();
    
    /**
     * Verifica si existen errores críticos en las validaciones
     * 
     * @return Número total de errores críticos encontrados
     */
    @Query(value = """
        SELECT 
            (SELECT COUNT(*) FROM ERR_CARGA_INC) +
            (SELECT COUNT(*) FROM ERR_INCIDENCIA_TABLAS) +
            (SELECT COUNT(*) FROM ERR_TABLAS_INTERRUPCION) +
            (SELECT COUNT(*) FROM CONSISTENCIA_INCIDENCIA WHERE severidad = 'CRITICO') as total_errores_criticos
        """, nativeQuery = true)
    Integer contarErroresCriticos();
    
    /**
     * Limpia todas las tablas de errores antes de ejecutar nuevas validaciones
     */
    @Query(value = """
        TRUNCATE TABLE REP_CARGA_INC;
        TRUNCATE TABLE ERR_CARGA_INC;
        TRUNCATE TABLE CONSISTENCIA_INCIDENCIA;
        TRUNCATE TABLE ERR_INCIDENCIA_TABLAS;
        TRUNCATE TABLE ERR_TABLAS_INTERRUPCION;
        """, nativeQuery = true)
    @Transactional
    @Modifying
    void limpiarTablasErrores();
}
