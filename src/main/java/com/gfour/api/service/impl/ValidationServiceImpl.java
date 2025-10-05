package com.gfour.api.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfour.api.repository.ValidationRepository;
import com.gfour.api.service.ValidationService;

/**
 * Implementación del servicio de validaciones
 * Ejecuta los stored procedures de validación equivalentes a frmPrincipal.vb
 */
@Service
@Transactional
public class ValidationServiceImpl implements ValidationService {
    
    private static final Logger logger = LoggerFactory.getLogger(ValidationServiceImpl.class);
    
    @Autowired
    private ValidationRepository validationRepository;

    /**
     * Ejecuta spa_scs_valida_carga
     * Equivalente a la validación de conectividad en frmPrincipal.vb
     */
    @Override
    public List<Map<String, Object>> scsValidaCarga() {
        logger.info("Ejecutando stored procedure: spa_scs_valida_carga");
        
        try {
            return validationRepository.ejecutarValidacionCarga();
        } catch (Exception e) {
            logger.error("Error ejecutando spa_scs_valida_carga: {}", e.getMessage(), e);
            throw new RuntimeException("Error en validación de carga: " + e.getMessage(), e);
        }
    }

    /**
     * Ejecuta spa_scs_valida_consistencia
     * Equivalente a las validaciones de consistencia en frmPrincipal.vb
     */
    @Override
    public List<Map<String, Object>> scsValidaCargaConsistencia() {
        logger.info("Ejecutando stored procedure: spa_scs_valida_consistencia");
        
        try {
            return validationRepository.ejecutarValidacionConsistencia();
        } catch (Exception e) {
            logger.error("Error ejecutando spa_scs_valida_consistencia: {}", e.getMessage(), e);
            throw new RuntimeException("Error en validación de consistencia: " + e.getMessage(), e);
        }
    }

    /**
     * Ejecuta spa_scs_valida_incidencias_tablas
     * Equivalente a la validación de incidencias en frmPrincipal.vb
     */
    @Override
    public List<Map<String, Object>> scsValidaIncidencias() {
        logger.info("Ejecutando stored procedure: spa_scs_valida_incidencias_tablas");
        
        try {
            return validationRepository.ejecutarValidacionIncidenciasTablas();
        } catch (Exception e) {
            logger.error("Error ejecutando spa_scs_valida_incidencias_tablas: {}", e.getMessage(), e);
            throw new RuntimeException("Error en validación de incidencias: " + e.getMessage(), e);
        }
    }

    /**
     * Ejecuta spa_scs_valida_tablas_interrup
     * Equivalente a la validación de tablas de interrupciones en frmPrincipal.vb
     */
    @Override
    public List<Map<String, Object>> scsValidaTablasInterrupciones() {
        logger.info("Ejecutando stored procedure: spa_scs_valida_tablas_interrup");
        
        try {
            return validationRepository.ejecutarValidacionTablasInterrupcion();
        } catch (Exception e) {
            logger.error("Error ejecutando spa_scs_valida_tablas_interrup: {}", e.getMessage(), e);
            throw new RuntimeException("Error en validación de tablas de interrupciones: " + e.getMessage(), e);
        }
    }
}
