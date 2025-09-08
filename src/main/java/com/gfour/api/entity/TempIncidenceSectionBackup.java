package com.gfour.api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla tmp_respaldo_tramos_incidencia
 * Contiene información temporal de respaldo de tramos de incidencias
 */
@Entity
@Table(name = "tmp_respaldo_tramos_incidencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TempIncidenceSectionBackup extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_tramo", length = 60, nullable = false)
    private String idTramo;

    @Column(name = "incidencia_id", nullable = false)
    private Integer incidenciaId;

    @Column(name = "n1", precision = 15, scale = 0, nullable = false)
    private BigDecimal n1;

    @Column(name = "n2", precision = 15, scale = 0, nullable = false)
    private BigDecimal n2;

    @Column(name = "conectividad")
    private Integer conectividad;
}
