package com.gfour.api.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ValidationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ejecutarValidacionCarga() {
        Query query = entityManager.createNativeQuery("CALL spa_scs_valida_carga()");
        return query.getResultList();
    }
    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ejecutarValidacionConsistencia() {
        Query query = entityManager.createNativeQuery("CALL spa_scs_valida_consistencia()");
        return query.getResultList();
    }
    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ejecutarValidacionIncidenciasTablas() {
        Query query = entityManager.createNativeQuery("CALL spa_scs_valida_incidencias_tablas()");
        return query.getResultList();
    }
    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ejecutarValidacionTablasInterrupcion() {
        Query query = entityManager.createNativeQuery("CALL spa_scs_valida_tablas_interrup()");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> obtenerReporteCarga() {
        Query query = entityManager.createNativeQuery("SELECT * FROM REP_CARGA_INC ORDER BY archivo");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> obtenerErroresCarga() {
        Query query = entityManager.createNativeQuery("SELECT * FROM ERR_CARGA_INC ORDER BY TABLA, ID");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> obtenerInconsistencias() {
        Query query = entityManager.createNativeQuery("SELECT * FROM CONSISTENCIA_INCIDENCIA ORDER BY incidencia_id");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> obtenerErroresIncidenciasTablas() {
        Query query = entityManager.createNativeQuery("SELECT * FROM ERR_INCIDENCIA_TABLAS ORDER BY Incidencia_Hija");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> obtenerErroresTablasInterrupcion() {
        Query query = entityManager.createNativeQuery("SELECT * FROM ERR_TABLAS_INTERRUPCION ORDER BY empresa_id, periodo_star, Incidencia_Padre");
        return query.getResultList();
    }

    public Integer contarErroresCriticos() {
        Query query = entityManager.createNativeQuery(
            "SELECT " +
            "  (SELECT COUNT(*) FROM ERR_CARGA_INC) + " +
            "  (SELECT COUNT(*) FROM ERR_INCIDENCIA_TABLAS) + " +
            "  (SELECT COUNT(*) FROM ERR_TABLAS_INTERRUPCION) + " +
            "  (SELECT COUNT(*) FROM CONSISTENCIA_INCIDENCIA WHERE severidad = 'CRITICO') as total_errores_criticos"
        );
        Number result = (Number) query.getSingleResult();
        return result != null ? result.intValue() : 0;
    }

    @Transactional
    public void limpiarTablasErrores() {
        entityManager.createNativeQuery("TRUNCATE TABLE REP_CARGA_INC").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE ERR_CARGA_INC").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE CONSISTENCIA_INCIDENCIA").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE ERR_INCIDENCIA_TABLAS").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE ERR_TABLAS_INTERRUPCION").executeUpdate();
    }
}
