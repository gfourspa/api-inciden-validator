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
 * Entidad que representa la tabla tipo_fuente_energia
 * Contiene información sobre los tipos de fuentes de energía
 */
@Entity
@Table(name = "tipo_fuente_energia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnergySourceType extends Audit {

    @Id
    @Column(name = "tipo_fuente_energia_id", nullable = false)
    private Integer tipoFuenteEnergiaId;

    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
}
