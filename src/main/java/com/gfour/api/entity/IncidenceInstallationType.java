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
 * Entidad que representa la tabla tipo_instalacion_incidencia
 * Contiene información sobre los tipos de instalación de incidencias
 */
@Entity
@Table(name = "tipo_instalacion_incidencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenceInstallationType extends Audit {

    @Id
    @Column(name = "tipo_instalacion_incidencia_id", nullable = false)
    private Integer tipoInstalacionIncidenciaId;

    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
}
