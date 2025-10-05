package com.gfour.api.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para el resultado de validación de incidencias e interrupciones
 * Basado en la funcionalidad de frmPrincipal.vb
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Resultado de ejecución de validaciones de incidencias eléctricas")
public class ValidationResultDTO {
    
    @Schema(description = "Tipo de validación ejecutada", example = "CONECTIVIDAD")
    private String validationType;
    
    @Schema(description = "Descripción detallada de la validación")
    private String description;
    
    @Schema(description = "Nombre del proceso ejecutado")
    private String processName;
    
    @Schema(description = "Indica si la validación fue exitosa", example = "true")
    private boolean success;
    
    @Schema(description = "Mensaje informativo del resultado", example = "Validación completada exitosamente")
    private String message;
    
    @Schema(description = "Mensaje de error en caso de falla")
    private String errorMessage;
    
    @Schema(description = "Número de registros procesados", example = "150")
    private int recordsProcessed;
    
    @Schema(description = "Total de registros disponibles")
    private Integer totalRecords;
    
    @Schema(description = "Número de errores encontrados")
    private Integer errorCount;
    
    @Schema(description = "Lista detallada de errores de validación")
    private List<ValidationErrorDTO> errors;
    
    @Schema(description = "Resultados detallados de la validación")
    private List<Map<String, Object>> results;
    
    @Schema(description = "Fecha y hora de inicio de la validación")
    private LocalDateTime startTime;
    
    @Schema(description = "Fecha y hora de fin de la validación")
    private LocalDateTime endTime;
    
    @Schema(description = "Tiempo total de ejecución en milisegundos", example = "2000")
    private long executionTimeMillis;
    
    public void calculateExecutionTime() {
        if (startTime != null && endTime != null) {
            executionTimeMillis = Duration.between(startTime, endTime).toMillis();
        }
    }
    
    /**
     * Calcula la duración de la validación en formato HH:mm:ss.fff
     * Similar al formato usado en frmPrincipal.vb
     */
    public String getDurationFormatted() {
        if (startTime != null && endTime != null) {
            Duration duration = Duration.between(startTime, endTime);
            long seconds = duration.getSeconds();
            long hours = seconds / 3600;
            long minutes = (seconds % 3600) / 60;
            long secs = seconds % 60;
            long millis = duration.toMillis() % 1000;
            
            return String.format("%02d:%02d:%02d.%03d", hours, minutes, secs, millis);
        }
        return null;
    }
}
