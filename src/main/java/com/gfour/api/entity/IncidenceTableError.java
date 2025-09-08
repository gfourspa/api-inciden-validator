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
 * Entidad que representa la tabla err_incidencia_tablas
 * Contiene información sobre errores de integridad entre tablas de incidencias
 */
@Entity
@Table(name = "err_incidencia_tablas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenceTableError extends Audit {

    @Column(name = "chequeo", length = 100)
    private String chequeo;

    @Column(name = "empresa_id", length = 3)
    private String empresaId;

    @Column(name = "periodo_star", length = 20)
    private String periodoStar;

    @Column(name = "tabla_padre", length = 100)
    private String tablaPadre;

    @Column(name = "incidencia_padre")
    private Integer incidenciaPadre;

    @Column(name = "tabla_hija", length = 100)
    private String tablaHija;

    @Column(name = "incidencia_hija")
    private Integer incidenciaHija;
}
