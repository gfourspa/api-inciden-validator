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
 * Entidad que representa la tabla chequeo_incidencia
 * Contiene información sobre chequeos de incidencias entre tablas padre e hija
 */
@Entity
@Table(name = "chequeo_incidencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenceCheck extends Audit {

    @Column(name = "tablapadre", length = 50)
    private String tablaPadre;

    @Column(name = "incidencia_id_padre", length = 50)
    private String incidenciaIdPadre;

    @Column(name = "tablahija", length = 50)
    private String tablaHija;

    @Column(name = "incidencia_id_hija", length = 50)
    private String incidenciaIdHija;
}
