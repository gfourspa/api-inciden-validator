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
 * Entidad que representa la tabla tipo_origen_interrupcion
 * Contiene información sobre los tipos de origen de interrupciones
 */
@Entity
@Table(name = "tipo_origen_interrupcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterruptionOriginType extends Audit {

    @Id
    @Column(name = "tipo_origen_interrupcion_id", nullable = false)
    private Integer tipoOrigenInterrupcionId;

    @Column(name = "descripcion", length = 250, nullable = false)
    private String descripcion;
}
