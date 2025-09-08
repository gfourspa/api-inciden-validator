package com.gfour.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla tipo_ruralidad
 * Contiene información sobre los tipos de ruralidad
 */
@Entity
@Table(name = "tipo_ruralidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuralityType extends Audit {

    @Id
    @Column(name = "tipo_ruralidad_id", nullable = false)
    private Integer tipoRuralidadId;

    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
}
