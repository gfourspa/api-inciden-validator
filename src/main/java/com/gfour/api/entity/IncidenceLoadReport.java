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
 * Entidad que representa la tabla rep_carga_inc
 * Contiene información sobre el reporte de carga de incidencias
 */
@Entity
@Table(name = "rep_carga_inc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenceLoadReport extends Audit {

    @Id
    @Column(name = "archivo", length = 255, nullable = false)
    private String archivo;

    @Column(name = "inicio", length = 255, nullable = false)
    private String inicio;

    @Column(name = "fin", length = 255, nullable = false)
    private String fin;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "enviados", nullable = false)
    private Integer enviados;

    @Column(name = "cargados", length = 255, nullable = false)
    private String cargados;

    @Column(name = "diferencia", nullable = false)
    private Integer diferencia;
}
