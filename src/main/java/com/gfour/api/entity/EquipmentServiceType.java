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
 * Entidad que representa la tabla tipo_servicio_equipo
 * Contiene información sobre los tipos de servicio de equipos
 */
@Entity
@Table(name = "tipo_servicio_equipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentServiceType extends Audit {

    @Id
    @Column(name = "tipo_servicio_equipo_id", nullable = false)
    private Integer tipoServicioEquipoId;

    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
}
