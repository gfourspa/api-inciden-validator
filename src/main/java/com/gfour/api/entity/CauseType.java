package com.gfour.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla tipo_causas
 * Contiene información sobre los tipos de causas de interrupciones
 */
@Entity
@Table(name = "tipo_causas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CauseType extends Audit {

    @Column(name = "causa_id")
    private Integer causaId;

    @Column(name = "clasificacion", columnDefinition = "TEXT")
    private String clasificacion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "calificacion_interrupcion_id")
    private Integer calificacionInterrupcionId;
}
