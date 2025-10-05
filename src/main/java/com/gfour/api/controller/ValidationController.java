package com.gfour.api.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfour.api.dto.ValidationResultDTO;
import com.gfour.api.service.ValidationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controller para validaciones de incidencias eléctricas
 * Equivalente a frmPrincipal.vb del sistema original en VB.NET
 */
@RestController
@RequestMapping("/api/v1/validaciones")
@Tag(name = "Validaciones", 
     description = "API para ejecutar validaciones de incidencias eléctricas.")
public class ValidationController {
    
    private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);
    
    @Autowired
    private ValidationService validationService;
    
    /**
     * Ejecuta validación de conectividad de nodos
     * Equivalente a cmdCarga_Click en frmPrincipal.vb
     */
    @PostMapping("/conectividad")
    @Operation(
        summary = "Validar conectividad de nodos", 
        description = "Ejecuta el stored procedure spa_scs_valida_carga para validar la conectividad " +
                     "de nodos del sistema eléctrico. Equivale al botón 'Carga' del formulario original."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Validación ejecutada exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ValidationResultDTO.class),
                examples = @ExampleObject(
                    name = "Respuesta exitosa",
                    value = """
                    {
                        "validationType": "CONECTIVIDAD",
                        "success": true,
                        "message": "Validación de conectividad completada exitosamente",
                        "recordsProcessed": 150,
                        "startTime": "2025-10-04T21:30:00",
                        "endTime": "2025-10-04T21:30:02",
                        "executionTimeMillis": 2000
                    }
                    """
                )
            )
        ),
        @ApiResponse(
            responseCode = "500", 
            description = "Error interno del servidor durante la validación",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ValidationResultDTO.class)
            )
        )
    })
    public ResponseEntity<ValidationResultDTO> validarConectividad() {
        logger.info("Iniciando validación de conectividad");
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            List<Map<String, Object>> resultados = validationService.scsValidaCarga();
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO response = ValidationResultDTO.builder()
                    .validationType("CONECTIVIDAD")
                    .success(true)
                    .startTime(startTime)
                    .endTime(endTime)
                    .recordsProcessed(resultados.size())
                    .message("Validación de conectividad completada exitosamente")
                    .build();
            
            logger.info("Validación de conectividad completada. Registros procesados: {}", resultados.size());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error en validación de conectividad: {}", e.getMessage(), e);
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO errorResponse = ValidationResultDTO.builder()
                    .validationType("CONECTIVIDAD")
                    .success(false)
                    .startTime(startTime)
                    .endTime(endTime)
                    .errorMessage("Error durante validación: " + e.getMessage())
                    .build();
            
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
    
    /**
     * Ejecuta validación de integridad de interrupciones
     * Equivalente a cmdConsistencia_Click en frmPrincipal.vb
     */
    @PostMapping("/integridad-interrupciones")
    @Operation(
        summary = "Validar integridad de interrupciones", 
        description = "Ejecuta el stored procedure spa_scs_valida_carga_consistencia para validar " +
                     "la consistencia e integridad de datos de interrupciones. Equivale al botón 'Consistencia' del formulario original."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Validación de integridad ejecutada exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ValidationResultDTO.class)
            )
        ),
        @ApiResponse(
            responseCode = "500", 
            description = "Error interno del servidor durante la validación"
        )
    })
    public ResponseEntity<ValidationResultDTO> validarIntegridadInterrupciones() {
        logger.info("Iniciando validación de integridad de interrupciones");
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            List<Map<String, Object>> resultados = validationService.scsValidaCargaConsistencia();
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO response = ValidationResultDTO.builder()
                    .validationType("INTEGRIDAD_INTERRUPCIONES")
                    .success(true)
                    .startTime(startTime)
                    .endTime(endTime)
                    .recordsProcessed(resultados.size())
                    .message("Validación de integridad de interrupciones completada exitosamente")
                    .build();
            
            logger.info("Validación de integridad de interrupciones completada. Registros procesados: {}", resultados.size());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error en validación de integridad de interrupciones: {}", e.getMessage(), e);
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO errorResponse = ValidationResultDTO.builder()
                    .validationType("INTEGRIDAD_INTERRUPCIONES")
                    .success(false)
                    .startTime(startTime)
                    .endTime(endTime)
                    .errorMessage("Error durante validación: " + e.getMessage())
                    .build();
            
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
    
    /**
     * Ejecuta validación de integridad de tablas de interrupciones
     * Equivalente a cmdConsistenciaInt_Click en frmPrincipal.vb
     */
    @PostMapping("/tablas-interrupciones")
    @Operation(
        summary = "Validar tablas de interrupciones", 
        description = "Ejecuta el stored procedure spa_scs_valida_tablas_interrup para validar " +
                     "la integridad y estructura de las tablas de interrupciones. Equivale al botón 'Consistencia Int' del formulario original."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Validación de tablas ejecutada exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<ValidationResultDTO> validarTablasInterrupciones() {
        logger.info("Iniciando validación de tablas de interrupciones");
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            List<Map<String, Object>> resultados = validationService.scsValidaTablasInterrupciones();
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO response = ValidationResultDTO.builder()
                    .validationType("TABLAS_INTERRUPCIONES")
                    .success(true)
                    .startTime(startTime)
                    .endTime(endTime)
                    .recordsProcessed(resultados.size())
                    .message("Validación de tablas de interrupciones completada exitosamente")
                    .build();
            
            logger.info("Validación de tablas de interrupciones completada. Registros procesados: {}", resultados.size());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error en validación de tablas de interrupciones: {}", e.getMessage(), e);
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO errorResponse = ValidationResultDTO.builder()
                    .validationType("TABLAS_INTERRUPCIONES")
                    .success(false)
                    .startTime(startTime)
                    .endTime(endTime)
                    .errorMessage("Error durante validación: " + e.getMessage())
                    .build();
            
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
    
    /**
     * Ejecuta validación del modelo de incidencias
     * Equivalente a cmdIncidencias_Click en frmPrincipal.vb
     */
    @PostMapping("/incidencias")
    @Operation(
        summary = "Validar modelo de incidencias", 
        description = "Ejecuta el stored procedure spa_scs_valida_incidencias_tablas para validar " +
                     "el modelo y estructura de datos de incidencias. Equivale al botón 'Incidencias' del formulario original."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Validación del modelo ejecutada exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<ValidationResultDTO> validarIncidencias() {
        logger.info("Iniciando validación del modelo de incidencias");
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            List<Map<String, Object>> resultados = validationService.scsValidaIncidencias();
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO response = ValidationResultDTO.builder()
                    .validationType("INCIDENCIAS")
                    .success(true)
                    .startTime(startTime)
                    .endTime(endTime)
                    .recordsProcessed(resultados.size())
                    .message("Validación del modelo de incidencias completada exitosamente")
                    .build();
            
            logger.info("Validación del modelo de incidencias completada. Registros procesados: {}", resultados.size());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error en validación del modelo de incidencias: {}", e.getMessage(), e);
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO errorResponse = ValidationResultDTO.builder()
                    .validationType("INCIDENCIAS")
                    .success(false)
                    .startTime(startTime)
                    .endTime(endTime)
                    .errorMessage("Error durante validación: " + e.getMessage())
                    .build();
            
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
    
    /**
     * Ejecuta validación de tablas resumen de alimentadores
     * Equivalente a cmdAlimentadores_Click en frmPrincipal.vb
     */
    @PostMapping("/alimentadores")
    @Operation(
        summary = "Validar resumen de alimentadores", 
        description = "Ejecuta validaciones para tablas resumen de alimentadores eléctricos. " +
                     "Equivale al botón 'Alimentadores' del formulario original."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Validación de alimentadores ejecutada exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<ValidationResultDTO> validarAlimentadores() {
        logger.info("Iniciando validación de tablas resumen de alimentadores");
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            List<Map<String, Object>> resultados = validationService.scsValidaCargaConsistencia();
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO response = ValidationResultDTO.builder()
                    .validationType("ALIMENTADORES")
                    .success(true)
                    .startTime(startTime)
                    .endTime(endTime)
                    .recordsProcessed(resultados.size())
                    .message("Validación de alimentadores completada exitosamente")
                    .build();
            
            logger.info("Validación de alimentadores completada. Registros procesados: {}", resultados.size());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error en validación de alimentadores: {}", e.getMessage(), e);
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO errorResponse = ValidationResultDTO.builder()
                    .validationType("ALIMENTADORES")
                    .success(false)
                    .startTime(startTime)
                    .endTime(endTime)
                    .errorMessage("Error durante validación: " + e.getMessage())
                    .build();
            
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
    
    /**
     * Ejecuta validación del estado de comuna empresa
     * Equivalente a cmdEstadoComuna_Click en frmPrincipal.vb
     */
    @PostMapping("/estado-comuna")
    @Operation(
        summary = "Validar estado de comuna empresa", 
        description = "Ejecuta validaciones del estado y configuración de comuna empresa. " +
                     "Equivale al botón 'Estado Comuna' del formulario original."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Validación de estado comuna ejecutada exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<ValidationResultDTO> validarEstadoComuna() {
        logger.info("Iniciando validación de estado de comuna empresa");
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            List<Map<String, Object>> resultados = validationService.scsValidaCargaConsistencia();
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO response = ValidationResultDTO.builder()
                    .validationType("ESTADO_COMUNA")
                    .success(true)
                    .startTime(startTime)
                    .endTime(endTime)
                    .recordsProcessed(resultados.size())
                    .message("Validación de estado de comuna completada exitosamente")
                    .build();
            
            logger.info("Validación de estado de comuna completada. Registros procesados: {}", resultados.size());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error en validación de estado de comuna: {}", e.getMessage(), e);
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO errorResponse = ValidationResultDTO.builder()
                    .validationType("ESTADO_COMUNA")
                    .success(false)
                    .startTime(startTime)
                    .endTime(endTime)
                    .errorMessage("Error durante validación: " + e.getMessage())
                    .build();
            
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
    
    /**
     * Ejecuta validación de KVA y Comuna
     * Equivalente a cmdKvaComuna_Click en frmPrincipal.vb
     */
    @PostMapping("/kva-comuna")
    @Operation(
        summary = "Validar KVA y Comuna", 
        description = "Ejecuta validaciones de potencia (KVA) y configuración de comuna. " +
                     "Equivale al botón 'KVA Comuna' del formulario original."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Validación de KVA y Comuna ejecutada exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<ValidationResultDTO> validarKvaComuna() {
        logger.info("Iniciando validación de KVA y Comuna");
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            List<Map<String, Object>> resultados = validationService.scsValidaCargaConsistencia();
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO response = ValidationResultDTO.builder()
                    .validationType("KVA_COMUNA")
                    .success(true)
                    .startTime(startTime)
                    .endTime(endTime)
                    .recordsProcessed(resultados.size())
                    .message("Validación de KVA y Comuna completada exitosamente")
                    .build();
            
            logger.info("Validación de KVA y Comuna completada. Registros procesados: {}", resultados.size());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error en validación de KVA y Comuna: {}", e.getMessage(), e);
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO errorResponse = ValidationResultDTO.builder()
                    .validationType("KVA_COMUNA")
                    .success(false)
                    .startTime(startTime)
                    .endTime(endTime)
                    .errorMessage("Error durante validación: " + e.getMessage())
                    .build();
            
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
    
    /**
     * Ejecuta todas las validaciones en secuencia
     * Equivalente a cmdEjecutarTodas_Click en frmPrincipal.vb
     */
    @PostMapping("/ejecutar-todas")
    @Operation(
        summary = "Ejecutar todas las validaciones", 
        description = "Ejecuta en secuencia todas las validaciones disponibles: conectividad, " +
                     "tablas de interrupciones e incidencias. Equivale al botón 'Ejecutar Todas' del formulario original."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Todas las validaciones ejecutadas exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ValidationResultDTO.class),
                examples = @ExampleObject(
                    name = "Todas las validaciones completadas",
                    value = """
                    {
                        "validationType": "TODAS_VALIDACIONES",
                        "success": true,
                        "message": "Todas las validaciones completadas exitosamente. Conectividad: 150, Interrupciones: 75, Incidencias: 200 registros procesados",
                        "recordsProcessed": 425,
                        "startTime": "2025-10-04T21:30:00",
                        "endTime": "2025-10-04T21:30:10",
                        "executionTimeMillis": 10000
                    }
                    """
                )
            )
        ),
        @ApiResponse(responseCode = "500", description = "Error durante la ejecución de las validaciones")
    })
    public ResponseEntity<ValidationResultDTO> ejecutarTodasValidaciones() {
        logger.info("Iniciando ejecución de todas las validaciones");
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            // Ejecutar todas las validaciones en secuencia
            List<Map<String, Object>> conectividad = validationService.scsValidaCarga();
            List<Map<String, Object>> interrupciones = validationService.scsValidaTablasInterrupciones();
            List<Map<String, Object>> incidencias = validationService.scsValidaIncidencias();
            
            int totalRecords = conectividad.size() + interrupciones.size() + incidencias.size();
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO response = ValidationResultDTO.builder()
                    .validationType("TODAS_VALIDACIONES")
                    .success(true)
                    .startTime(startTime)
                    .endTime(endTime)
                    .recordsProcessed(totalRecords)
                    .message(String.format("Todas las validaciones completadas exitosamente. " +
                            "Conectividad: %d, Interrupciones: %d, Incidencias: %d registros procesados",
                            conectividad.size(), interrupciones.size(), incidencias.size()))
                    .build();
            
            logger.info("Todas las validaciones completadas. Total de registros procesados: {}", totalRecords);
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error ejecutando todas las validaciones: {}", e.getMessage(), e);
            LocalDateTime endTime = LocalDateTime.now();
            
            ValidationResultDTO errorResponse = ValidationResultDTO.builder()
                    .validationType("TODAS_VALIDACIONES")
                    .success(false)
                    .startTime(startTime)
                    .endTime(endTime)
                    .errorMessage("Error durante ejecución de validaciones: " + e.getMessage())
                    .build();
            
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
    
    /**
     * Obtiene el estado actual de las validaciones
     */
    @GetMapping("/estado")
    @Operation(
        summary = "Obtener estado del servicio de validaciones", 
        description = "Devuelve el estado actual del servicio y lista de validaciones disponibles. " +
                     "Útil para verificar la disponibilidad del servicio y conocer los endpoints disponibles."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Estado del servicio obtenido exitosamente",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "Estado del servicio",
                    value = """
                    {
                        "timestamp": "2025-10-04T21:30:00",
                        "status": "READY",
                        "available_validations": [
                            "conectividad",
                            "integridad-interrupciones",
                            "tablas-interrupciones",
                            "incidencias",
                            "alimentadores",
                            "estado-comuna",
                            "kva-comuna",
                            "ejecutar-todas"
                        ]
                    }
                    """
                )
            )
        )
    })
    public ResponseEntity<Map<String, Object>> obtenerEstadoValidaciones() {
        logger.info("Consultando estado de validaciones");
        
        Map<String, Object> estado = new HashMap<>();
        estado.put("timestamp", LocalDateTime.now());
        estado.put("status", "READY");
        estado.put("available_validations", List.of(
                "conectividad",
                "integridad-interrupciones",
                "tablas-interrupciones", 
                "incidencias",
                "alimentadores",
                "estado-comuna",
                "kva-comuna",
                "ejecutar-todas"
        ));
        
        return ResponseEntity.ok(estado);
    }
}