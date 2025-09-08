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
 * Entidad que representa la tabla alimentador_afectado
 * Contiene información sobre los alimentadores afectados por interrupciones
 */
@Entity
@Table(name = "alimentador_afectado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(AffectedFeederPK.class)
public class AffectedFeederDetail extends Audit {

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

    @Column(name = "kva_interrumpidos_u", precision = 10, scale = 2, nullable = false)
    private BigDecimal kvaInterrumpidosU;

    @Column(name = "kva_interrumpidos_r1", precision = 10, scale = 2, nullable = false)
    private BigDecimal kvaInterrumpidosR1;

    @Column(name = "total_tranfo_int_u", nullable = false)
    private Integer totalTranfoIntU;

    @Column(name = "total_clientes_int", nullable = false)
    private Integer totalClientesInt;

    @Column(name = "total_tranfo_int_r1", nullable = false)
    private Integer totalTranfoIntR1;

    @Column(name = "kva_interrumpidos_r2", precision = 10, scale = 2, nullable = false)
    private BigDecimal kvaInterrumpidosR2;

    @Column(name = "total_tranfo_int_r2", nullable = false)
    private Integer totalTranfoIntR2;
}

/**
 * Clase para la clave primaria compuesta de AffectedFeederDetail
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class AffectedFeederPK extends Audit {
    private String empresaId;
    private String periodoStar;
    private Integer incidenciaId;
    private Integer alimentadorId;
    private String interrupcionId;
}
