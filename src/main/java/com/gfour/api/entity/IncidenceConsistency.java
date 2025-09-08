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
 * Entidad que representa la tabla consistencia_incidencia
 * Contiene información sobre inconsistencias encontradas en las incidencias
 */
@Entity
@Table(name = "consistencia_incidencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenceConsistency extends Audit {

    @Column(name = "tabla", length = 200)
    private String tabla;

    @Column(name = "tabla_comparada", length = 200)
    private String tablaComparada;

    @Column(name = "incidencia")
    private Integer incidencia;

    @Column(name = "alimentador")
    private Integer alimentador;

    @Column(name = "observacion", length = 200)
    private String observacion;

    @Column(name = "tipo_error", length = 100)
    private String tipoError;
}
