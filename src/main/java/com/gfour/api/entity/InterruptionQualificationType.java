package com.gfour.api.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla tipo_calificacion_interrupcion
 * Contiene información sobre los tipos de calificación de interrupciones
 */
@Entity
@Table(name = "tipo_calificacion_interrupcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterruptionQualificationType extends Audit {

    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "calificacion_interrupcion_id")
    private Integer calificacionInterrupcionId;

    @Column(name = "descripcion", length = 60)
    private String descripcion;
}
