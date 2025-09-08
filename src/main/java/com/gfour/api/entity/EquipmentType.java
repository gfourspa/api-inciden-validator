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
 * Entidad que representa la tabla tipo_equipo
 * Contiene información sobre los tipos de equipos
 */
@Entity
@Table(name = "tipo_equipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentType extends Audit {

    @Column(name = "tipo_equipo_id", length = 50)
    private String tipoEquipoId;

    @Column(name = "descripcion", length = 50)
    private String descripcion;
}
