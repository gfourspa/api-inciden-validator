package com.gfour.api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla alimentador_reposicion
 * Contiene información sobre la reposición de alimentadores
 */
@Entity
@Table(name = "alimentador_reposicion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(FeederRestorationDetailPK.class)
public class FeederRestorationDetail extends Audit {

    @Id
    @Column(name = "empresa_id", length = 3, nullable = false)
    private String empresaId;

    @Id
    @Column(name = "periodo_star", length = 6, nullable = false)
    private String periodoStar;

    @Id
    @Column(name = "incidencia_id", nullable = false)
    private Integer incidenciaId;

    @Id
    @Column(name = "alimentador_id", nullable = false)
    private Integer alimentadorId;

    @Id
    @Column(name = "interrupcion_id", length = 18, nullable = false)
    private String interrupcionId;

    @Id
    @Column(name = "bloque_reposicion_id", nullable = false)
    private Integer bloqueReposicionId;

    @Column(name = "kva_repuestos_r1", precision = 10, scale = 2, nullable = false)
    private BigDecimal kvaRepuestosR1;

    @Column(name = "kva_repuestos_u", precision = 10, scale = 2, nullable = false)
    private BigDecimal kvaRepuestosU;

    @Column(name = "kva_repuestos_r2", precision = 10, scale = 2, nullable = false)
    private BigDecimal kvaRepuestosR2;
}

/**
 * Clase para la clave primaria compuesta de FeederRestorationDetail
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class FeederRestorationDetailPK extends Audit {
    private String empresaId;
    private String periodoStar;
    private Integer incidenciaId;
    private Integer alimentadorId;
    private String interrupcionId;
    private Integer bloqueReposicionId;
}
