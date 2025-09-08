package com.gfour.api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla tmp_tramos_incidencia
 * Contiene información temporal sobre tramos de incidencias
 */
@Entity
@Table(name = "tmp_tramos_incidencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TempIncidenceSection extends Audit {

    @Column(name = "empresa_id", length = 3)
    private String empresaId;

    @Column(name = "periodo_star", length = 6)
    private String periodoStar;

    @Column(name = "incidencia_id")
    private Integer incidenciaId;

    @Column(name = "n1", precision = 15, scale = 0)
    private BigDecimal n1;

    @Column(name = "n2", precision = 15, scale = 0)
    private BigDecimal n2;

    @Column(name = "id_tramo", length = 60)
    private String idTramo;
}
